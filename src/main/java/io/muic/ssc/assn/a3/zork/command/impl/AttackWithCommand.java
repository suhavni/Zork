package io.muic.ssc.assn.a3.zork.command.impl;

import io.muic.ssc.assn.a3.zork.command.Command;
import io.muic.ssc.assn.a3.zork.item.Item;
import io.muic.ssc.assn.a3.zork.item.ItemFactory;
import io.muic.ssc.assn.a3.zork.item.Weapon;
import io.muic.ssc.assn.a3.zork.map.Monster;

import java.util.Random;


public class AttackWithCommand extends Command {
    protected static final Random RANDOM = new Random();

    private void attackMonster(Monster monster, String arg) {
        game.getOutput().println("Trying to attack monster with " + arg);
        Item item = ItemFactory.getItemType(arg).getItemInstance();
        if (game.getCheckPoint().getPlayer().getInventory().carriesItem(arg) && item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            int attack = RANDOM.nextInt(game.getCheckPoint().getPlayer().getAttack() * (100+weapon.getAttackBonus())/100);
            game.getOutput().println("attacked with " + attack + " attack power.");
            monster.reduceHp(attack);
            game.getOutput().println("Monster's current HP is " + monster.getHp());
        } else {
            game.getOutput().println("Either player does not carry item, or this item is not a weapon");
        }
    }

    private void monsterStrikesBack(Monster monster) {
        if (monster.getHp() <= 0) {
            game.getOutput().println("Congratulations you killed the monster");
            game.getCheckPoint().getCurrentRoom().addMonster(null);
        } else {
            game.getOutput().println("Monster tries to attack back");
            int attack = RANDOM.nextInt(monster.getAttack());
            game.getOutput().println("attacked with " + attack + " attack power.");
            game.getCheckPoint().getPlayer().updateHp(-1*attack);
            game.getOutput().println("your current HP is " + game.getCheckPoint().getPlayer().getHp());
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
