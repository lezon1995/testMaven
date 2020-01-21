package runes.util;

import runes.domian.enemy.EnemyBase;
import runes.domian.tower.TowerBase;

import java.util.Random;

/**
 * 伤害计算类
 *
 * @author Wentworth .
 * @date 2020/1/20 4:30 下午
 */
public class DamageUtil {
    public static Random random = new Random();

    public static int calculateDamage(TowerBase tower, EnemyBase enemy) {

        //1计算当前防御塔的攻击力
        int damage = tower.attackDamage.damage;

        //2计算是否暴击
        if (random.nextFloat() < tower.attackDamage.criticalChance) {
            //产生一个[0,1]之间的随机数 如果该数<暴击率 则代表此次攻击暴击了
            damage *= 2;
        }

        //3计算护甲穿透
        //实际护甲
        int actureArmor = enemy.resistance.armorResistance - tower.attackDamage.penetration;

        //4伤害减免 = 总抗性 / (100+总抗性)
        int offset = actureArmor / (100 + actureArmor);

        //5最终伤害
        damage *= (1 - offset);

        return damage;
    }

    public static int calculateDamage(TowerBase tower, Integer towerDamage, EnemyBase enemy) {

        //2计算是否暴击
        if (random.nextFloat() < tower.attackDamage.criticalChance) {
            //产生一个[0,1]之间的随机数 如果该数<暴击率 则代表此次攻击暴击了
            towerDamage *= 2;
        }

        //3计算护甲穿透
        //实际护甲
        int actureArmor = enemy.resistance.armorResistance - tower.attackDamage.penetration;

        //4伤害减免 = 总抗性 / (100+总抗性)
        int offset = actureArmor / (100 + actureArmor);

        //5最终伤害
        towerDamage *= (1 - offset);

        return towerDamage;
    }

    public static void main(String[] args) {
        int yes = 0;
        int no = 0;
        int sum = 1000000;
        for (int i = 0; i < sum; i++) {
            if (random.nextFloat() <= 0.88F) {
                //产生一个[0,1]之间的随机数 如果该数<暴击率 则代表此次攻击暴击了
                yes++;
            } else {
                no++;
            }
        }
        System.out.println(yes / (sum * 1.0F));
        System.out.println(no / (sum * 1.0F));
    }
}
