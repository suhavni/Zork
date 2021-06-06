package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.Item;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;
import io.muic.ssc.assn.a3.zork.item.Weapon;
import io.muic.ssc.assn.a3.zork.map.Monster;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;


public class AttackWithCommand extends Command {
    protected Random random = new Random();

    private void attackMonster(Monster monster, String arg) {
        game.getOutput().println("\u001B[33mTrying to attack monster with " + arg + "\u001B[0m");
        if (ItemFactory.getItemType(arg) == null) {
            game.getOutput().println("This item does not exist in the game");
            return;
        }

        Item item = null;
        try {
            item = ItemFactory.getItemType(arg).getItemClass().getConstructor().newInstance();
            if (game.getCheckPoint().getPlayer().getInventory().carriesItem(arg) && item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                int attack = random.nextInt(game.getCheckPoint().getPlayer().getAttack() * (100+weapon.getAttackBonus())/100);
                game.getOutput().println("Attacked with " + attack + " attack power.");
                monster.reduceHp(attack);
            } else {
                game.getOutput().println("Either player does not carry item, or this item is not a weapon");
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
        }

    }

    private void monsterStrikesBack(Monster monster) {
        if (monster.getHp() <= 0) {
            game.getOutput().println("\u001B[32;7;1m Congratulations!! You killed the monster! \u001B[0m");
            game.getOutput().println("You received a hp potion");
            game.getCheckPoint().getPlayer().getInventory().addItemToInventory("hp potion");
            game.getCheckPoint().getCurrentRoom().addMonster(null);
            game.getCheckPoint().getMap().setMonsterCount(game.getCheckPoint().getMap().getMonsterCount()-1);
            if (game.getCheckPoint().getMap().getMonsterCount() == 0) {
                game.getOutput().println("\u001B[32;7;1m All monsters in map killed. You have won! Type \u001B[35;7;1mquit\u001B[32;7;1m to end session \u001B[0m");
            }
        } else {
            game.getOutput().println("Monster's current HP is " + monster.getHp());
            game.getOutput().println("Monster tries to attack back");
            int attack = random.nextInt(monster.getAttack());
            game.getOutput().println("Attacked with " + attack + " attack power.");
            game.getCheckPoint().getPlayer().updateHp(-1*attack);
            if (game.isPlayingGame()) {
                game.getOutput().println("Your current HP is " + game.getCheckPoint().getPlayer().getHp());
            }
        }
    }

    @Override
    public void execute(String arg) {
        Monster monster = game.getCheckPoint().getCurrentRoom().getMonster();
        if (monster == null) {
            game.getOutput().println("This room does not have any monster");
            return;
        }

        attackMonster(monster, arg);
        monsterStrikesBack(monster);
    }
}
