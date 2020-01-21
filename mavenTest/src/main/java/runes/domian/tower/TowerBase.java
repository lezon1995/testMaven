package runes.domian.tower;

import runes.domian.base.AttackDamageBase;
import runes.domian.enemy.EnemyBase;
import runes.domian.base.LifeBase;
import runes.domian.base.ResistanceBase;
import runes.domian.equipment.EquipmentSlot;
import runes.domian.rune.RuneSlot;

import java.util.Queue;

/**
 * 防御塔基类
 *
 * @author Wentworth .
 * @date 2020/1/20 11:33 上午
 */
public class TowerBase {
    /**
     * 防御塔生命
     */
    public LifeBase life;
    /**
     * 防御塔物理攻击
     */
    public AttackDamageBase attackDamage;
    /**
     * 防御塔抗性
     */
    public ResistanceBase resistance;
    /**
     * 符文卡槽 默认为3个
     * 当防御塔被一个符文所装备 会给防御塔提供符文的特殊能力
     * 当防御塔被三个符文所装备 会给防御塔提供三个符文组合成的羁绊能力
     */
    public RuneSlot runeSlot;
    /**
     * 装备卡槽 默认为3个
     */
    public EquipmentSlot equipmentSlot;
    /**
     * 敌人队列 当敌人依次进入防御塔攻击范围时会将敌人依次添加到队列中
     * 当敌人被阵亡之后会从队列中除去
     */
    public Queue<EnemyBase> queue;
    /**
     * 当前正在攻击的敌人
     */
    public Queue<EnemyBase> currentAttackingQueue;

    public TowerBase(LifeBase life, AttackDamageBase attackDamage, ResistanceBase resistance, RuneSlot runeSlot, EquipmentSlot equipmentSlot) {
        this.life = life;
        this.attackDamage = attackDamage;
        this.resistance = resistance;
        this.runeSlot = runeSlot;
        this.equipmentSlot = equipmentSlot;
    }

}
