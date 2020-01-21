package runes.domian.enemy;

import runes.domian.base.*;
import runes.domian.skill.IDestroySkill;
import runes.domian.tower.TowerBase;

import java.util.Queue;

/**
 * 敌人基类
 *
 * @author Wentworth .
 * @date 2020/1/20 11:46 上午
 */
public class EnemyBase implements IDestroySkill {
    public LifeBase life;
    public LevelBase level;
    public AttackDamageBase attackDamage;
    public PowerDamageBase powerDamage;
    public ResistanceBase resistance;
    public DroppingBase dropping;
    /**
     * 防御塔队列 当敌人依次进入防御塔攻击范围时会将 防御塔 依次添加到队列中
     * 当敌人被阵亡之后会从队列取出所有的防御塔 并从防御塔的敌人队列中除去
     */
    public Queue<TowerBase> queue;

    public EnemyBase() {
    }

    public EnemyBase(LifeBase life, LevelBase level, AttackDamageBase attackDamage, PowerDamageBase powerDamage, ResistanceBase resistance, DroppingBase dropping) {
        this.life = life;
        this.level = level;
        this.attackDamage = attackDamage;
        this.powerDamage = powerDamage;
        this.resistance = resistance;
        this.dropping = dropping;
    }

    @Override
    public Object runDestroySkill() {
        System.out.println("Enemy Destroyed");
        queue.forEach(tower -> {
            tower.queue.remove(this);
        });
        return null;
    }
}
