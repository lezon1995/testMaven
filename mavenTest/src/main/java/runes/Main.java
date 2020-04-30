package runes;

import com.alibaba.fastjson.JSONArray;

public class Main {
    public static void main0(String[] args) {

        JSONArray array = new JSONArray();
        E attackSpeed = new E(
                "迅捷之弓",
                "攻速 +20%",
                null,
                null);
        E attackDamage = new E(
                "力量之斧",
                "物理攻击力 +20",
                null,
                null);
        E mpSpeed = new E(
                "汲取法球",
                "回蓝速度 +20%",
                null,
                null);
        E abilityPower = new E(
                "魔法权杖",
                "魔法攻击力 +20%",
                null,
                null);
        E mp = new E(
                "菱形水晶",
                "MP +20",
                null,
                null);
        E attackRange = new E(
                "精准之枪",
                "射程 +20%",
                null,
                null);
        E criticalChance = new E(
                "锋之尖刺",
                "物理暴击率 +15%",
                null,
                null);
        E attackSpeed2 = new E(
                "强攻连弩",
                "攻速 +20%",
                "攻速 +20%",
                "普通攻击时会有30%几率附加一次额外攻击");
        E attackSpeed_attackDamage = new E(
                "圣银锋芒",
                "攻速 +20%",
                "物理攻击力 +20",
                "普通攻击时附带最大生命值的4%的物理伤害");
        E attackSpeed_mpSpeed = new E(
                "魔力生长",
                "攻速 +20%",
                "回蓝速度 +20%",
                "每次普通攻击后会提高20%的基础回蓝速度 最多提高100%");
        E attackSpeed_abilityPower = new E(
                "贪婪连弩",
                "攻速 +20%",
                "魔法攻击力 +20%",
                "每次普通攻击后会提高5%的攻速(可无限叠加)");
        E attackSpeed_mp = new E(
                "魔能律动",
                "攻速 +20%",
                "MP +20",
                "每第4次普通攻击会产生魔能静电 可以溅射最多4个目标100点的魔法伤害");
        E attackSpeed_attackRange = new E(
                "神秘",
                "攻速 +20%",
                "射程 +20%",
                "防御塔离敌人越远攻击速度越高 当敌人处于防御塔基础射程的一半处到最大距离 提升的攻速为0%~100% 超过基础射程的距离会提高提升的攻击速度上限");
        E attackSpeed_criticalChance = new E(
                "审判之拳",
                "攻速 +20%",
                "物理暴击率 +15%",
                "每一次普通攻击暴击会削减敌人15%的基础护甲 最多削减80%");

        E attackDamage2 = new E(
                "灵魂收割者",
                "物理攻击力 +20",
                "物理攻击力 +20",
                "每摧毁一名敌人后会提高提高自身20点物理攻击力");
        E attackDamage_mpSpeed = new E(
                "魔力亲和",
                "物理攻击力 +20",
                "回蓝速度 +20%",
                "每次普通攻击后有20%几率提高10%的MaxMp");
        E attackDamage_abilityPower = new E(
                "均衡匕首",
                "物理攻击力 +20",
                "魔法攻击力 +20%",
                "将普通攻击造成伤害前50%的数值转化为魔法伤害");
        E attackDamage_mp = new E(
                "魔能收割者",
                "物理攻击力 +20",
                "MP +20",
                "每次摧毁一名敌人提高自身5%*MaxMp作为初始MP 最多提高5次");
        E attackDamage_attackRange = new E(
                "白昼",
                "物理攻击力 +20",
                "射程 +20%",
                "防御塔离敌人越远普通攻击伤害越高 当敌人处于防御塔基础射程的一半处到最大距离 受到伤害为100%~200% 超过基础射程的距离会提高提升的物理伤害上限");
        E attackDamage_criticalChance = new E(
                "毁灭之锤",
                "物理攻击力 +20",
                "物理暴击率 +15%",
                "提高50%的物理暴击伤害");

        E mpSpeed2 = new E(
                "魔能产生仪",
                "回蓝速度 +20%",
                "回蓝速度 +20%",
                "每秒回复5%的最大MaxMP");
        E mpSpeed_abilityPower = new E(
                "诅咒之杖",
                "回蓝速度 +20%",
                "魔法攻击力 +20%",
                "每次普通攻击附带敌人当前最大生命值的8%的魔法伤害");
        E mpSpeed_mp = new E(
                "贪婪面具",
                "回蓝速度 +20%",
                "MP +20",
                "每损失1%的MaxMP 提高2%的回蓝速度");
        E mpSpeed_attackRange = new E(
                "凝语",
                "回蓝速度 +20%",
                "射程 +20%",
                "防御塔离敌人越远普通攻击附带的减速效果越强 当敌人处于防御塔基础射程的1/2处到最大距离 减速效果为15%~30% 超过基础射程的距离会提高提升的减速效果上限");
        E mpSpeed_criticalChance = new E(
                "抑郁之血",
                "回蓝速度 +20%",
                "物理暴击率 +15%",
                "普通攻击造成暴击伤害会减少敌人50%的治疗效果持续5秒");

        E abilityPower2 = new E(
                "远古魔典",
                "魔法攻击力 +20%",
                "魔法攻击力 +20%",
                "所有造成的魔法伤害提高75%");
        E abilityPower_mp = new E(
                "不稳定魔能石",
                "魔法攻击力 +20%",
                "MP +20",
                "每个敌人命中的技能都会溅射周围范围内的所有目标 造成200点魔法伤害");
        E abilityPower_attackRange = new E(
                "黑夜",
                "魔法攻击力 +20%",
                "射程 +20%",
                "防御塔离敌人越远魔法伤害越高 当敌人处于防御塔基础射程的1/3处到最大距离 受到伤害为100%~200% 超过基础射程的距离会提高提升的魔法伤害上限");
        E abilityPower_criticalChance = new E(
                "死亡凝视",
                "魔法攻击力 +20%",
                "物理暴击率 +15%",
                "装备防御塔的技能可以产生魔法暴击 提高50%的魔法暴击伤害 和20%的魔法暴击率");

        E mp2 = new E(
                "魔能囚牢",
                "MP +20",
                "MP +20",
                "每次释放技能后让初始MP为MaxMP的30%");
        E mp_attackRange = new E(
                "低语",
                "MP +20",
                "射程 +20%",
                "恢复技能造成的最终伤害总和的8%的MP");
        E mp_criticalChance = new E(
                "暴走",
                "MP +20",
                "物理暴击率 +15%",
                "每次释放技能后 提高5%的魔法暴击率 最多提高5次");
        E attackRange2 = new E(
                "远攻之王",
                "射程 +20%",
                "射程 +20%",
                "每摧毁一个敌人 射程提高基础射程的10% 最多提高50%");
        E attackRange_criticalChance = new E(
                "致命",
                "射程 +20%",
                "物理暴击率 +15%",
                "防御塔离敌人越远物理暴击率越高 当敌人处于防御塔射程的1/2处到最大距离 物理暴击率提高0%~30% 超过基础射程的距离会提高提升的暴击率上限");
        E criticalChance2 = new E(
                "爆裂子弹",
                "物理暴击率 +15%",
                "物理暴击率 +15%",
                "每次物理暴击可以造成半径为(当前暴击率*当前射程*0.5)的爆炸伤害 伤害为暴击伤害的25%");


        attackSpeed.code = "attackSpeed";
        array.add(attackSpeed);
        attackDamage.code = "attackDamage";
        array.add(attackDamage);
        mpSpeed.code = "mpSpeed";
        array.add(mpSpeed);
        abilityPower.code = "abilityPower";
        array.add(abilityPower);
        mp.code = "mp";
        array.add(mp);
        attackRange.code = "attackRange";
        array.add(attackRange);
        criticalChance.code = "criticalChance";
        array.add(criticalChance);
        attackSpeed2.code = "attackSpeed2";
        array.add(attackSpeed2);
        attackSpeed_attackDamage.code = "attackSpeed_attackDamage";
        array.add(attackSpeed_attackDamage);
        attackSpeed_mpSpeed.code = "attackSpeed_mpSpeed";
        array.add(attackSpeed_mpSpeed);
        attackSpeed_abilityPower.code = "attackSpeed_abilityPower";
        array.add(attackSpeed_abilityPower);
        attackSpeed_mp.code = "attackSpeed_mp";
        array.add(attackSpeed_mp);
        attackSpeed_attackRange.code = "attackSpeed_attackRange";
        array.add(attackSpeed_attackRange);
        attackSpeed_criticalChance.code = "attackSpeed_criticalChance";
        array.add(attackSpeed_criticalChance);
        attackDamage2.code = "attackDamage2";
        array.add(attackDamage2);
        attackDamage_mpSpeed.code = "attackDamage_mpSpeed";
        array.add(attackDamage_mpSpeed);
        attackDamage_abilityPower.code = "attackDamage_abilityPower";
        array.add(attackDamage_abilityPower);
        attackDamage_mp.code = "attackDamage_mp";
        array.add(attackDamage_mp);
        attackDamage_attackRange.code = "attackDamage_attackRange";
        array.add(attackDamage_attackRange);
        attackDamage_criticalChance.code = "attackDamage_criticalChance";
        array.add(attackDamage_criticalChance);
        mpSpeed2.code = "mpSpeed2";
        array.add(mpSpeed2);
        mpSpeed_abilityPower.code = "mpSpeed_abilityPower";
        array.add(mpSpeed_abilityPower);
        mpSpeed_mp.code = "mpSpeed_mp";
        array.add(mpSpeed_mp);
        mpSpeed_attackRange.code = "mpSpeed_attackRange";
        array.add(mpSpeed_attackRange);
        mpSpeed_criticalChance.code = "mpSpeed_criticalChance";
        array.add(mpSpeed_criticalChance);
        abilityPower2.code = "abilityPower2";
        array.add(abilityPower2);
        abilityPower_mp.code = "abilityPower_mp";
        array.add(abilityPower_mp);
        abilityPower_attackRange.code = "abilityPower_attackRange";
        array.add(abilityPower_attackRange);
        abilityPower_criticalChance.code = "abilityPower_criticalChance";
        array.add(abilityPower_criticalChance);
        mp2.code = "mp2";
        array.add(mp2);
        mp_attackRange.code = "mp_attackRange";
        array.add(mp_attackRange);
        mp_criticalChance.code = "mp_criticalChance";
        array.add(mp_criticalChance);
        attackRange2.code = "attackRange2";
        array.add(attackRange2);
        attackRange_criticalChance.code = "attackRange_criticalChance";
        array.add(attackRange_criticalChance);
        criticalChance2.code = "criticalChance2";
        array.add(criticalChance2);

        System.out.println(array.toJSONString());
    }

    public static void main(String[] args) {

        JSONArray array = new JSONArray();
        Turret turret1 = new Turret("Turret_01_01", "冰霜箭塔", 1, "弓", "", "冰霜", "");
        Turret turret2 = new Turret("Turret_01_02", "火精箭塔", 2, "弓", "", "火", "");
        Turret turret3 = new Turret("Turret_01_03", "暴风箭塔", 3, "弓", "", "飓风", "");
        Turret turret4 = new Turret("Turret_02_01", "连弩箭塔", 1, "弩", "", "无", "");
        Turret turret5 = new Turret("Turret_02_02", "强击弩箭", 2, "弩", "", "击退", "");
        Turret turret6 = new Turret("Turret_03_01", "加特林机枪", 1, "枪", "", "无", "");
        Turret turret7 = new Turret("Turret_03_02", "狙击枪", 2, "枪", "", "无", "");
        Turret turret8 = new Turret("Turret_03_03", "霞弹枪", 3, "枪", "", "无", "");
        Turret turret9 = new Turret("Turret_04_01", "反坦克炮", 1, "炮", "", "无", "");
        Turret turret10 = new Turret("Turret_04_02", "镭射激光炮", 2, "炮", "", "无", "");
        Turret turret11 = new Turret("Turret_04_03", "电磁脉冲炮", 3, "炮", "", "无", "");
        Turret turret12 = new Turret("Turret_05_01", "聚焦火能枪", 1, "能量", "", "无", "");
        Turret turret13 = new Turret("Turret_05_02", "三菱光镜塔", 2, "能量", "", "无", "");
        Turret turret14 = new Turret("Turret_06_01", "激光发射器", 1, "激光", "", "无", "");
        Turret turret15 = new Turret("Turret_07_01", "羽刃塔", 1, "羽毛", "", "无", "");
        array.add(turret1);
        array.add(turret2);
        array.add(turret3);
        array.add(turret4);
        array.add(turret5);
        array.add(turret6);
        array.add(turret7);
        array.add(turret8);
        array.add(turret9);
        array.add(turret10);
        array.add(turret11);
        array.add(turret12);
        array.add(turret13);
        array.add(turret14);
        array.add(turret15);

        System.out.println(array.toJSONString());
    }
}

/*

冰霜箭塔
        蓄力1秒 射出一道3发(如果升级弓羁绊后可以增加至3道)凝聚寒冰气息的弓箭可以穿透敌人 对第一个敌人造成1/1.5/3的魔法攻击力伤害 每穿透一名敌人伤害减少10% 最多减少50% 并且冰冻敌人1秒钟
        普通攻击附带减速效果
        减速效果为15% / 25% / 35%
        火精箭塔
        向前方连续发射1道(如果升级弓羁绊后可以增加至3道)火精之箭 持续3秒 每发火精箭造成0.25的魔法攻击力伤害 可以附加[灼烧]被动
        普通攻击附带[灼烧]效果 每秒造成0.2的魔法攻击力伤害 持续3秒 可无限叠加
        暴风箭塔
        向前方射出一发暴风箭 召唤一阵暴风箭阵 在半径为1.5的区域内 从天空随机降落暴风箭雨 持续5秒 每一发箭造成0.25的魔法攻击力伤害
        每次普通攻击 提升5% / 7.5% 10%的攻速 最多提高5次
        连弩箭塔
        额外攻击一次 只造成25% / 50% /100%的物理攻击伤害
        每第3次普通攻击 射出两发弩箭 每只弩箭造成50% / 60% / 70%的物理攻击力伤害 附加攻击特效
        强击弩箭
        向前方扇形范围内发射5支弩箭 每只弩箭造成0.5的魔法攻击力伤害 并且附加攻击特效
        每第3次普通攻击 射出1发弩箭 击退敌人0.2米
        加特林机枪
        火力全开 攻击速度提高到3/4/5并且3秒内攻速提高100% 150% 200%
        加特林机枪普通攻击速度动画是固定的 为2 但是攻速提升会提高每发子弹的伤害
        狙击枪
        瞄准敌人 发射一发精准的狙击弹 对命中的第一个敌人造成1/1.5/2的物理攻击力 + 1/1.5/2的魔法攻击力总和的魔法伤害 并附加敌人已损失生命值的10% / 15% / 20%的真实伤害
        狙击枪不会从攻速装备中获取收益 但是会根据额外的攻速 和 暴击率 提升来提高 物理伤害
        +5%每增加10%攻击速度
        +4%每增加5%暴击几率
        +5%每增加10%射程
        霞弹枪
        对前方扇形区域内发射20发霞弹 每发霞弹造成0.4的物理攻击力+0.2的魔法攻击力的魔法伤害
        霞弹枪的普通攻击可以向前方扇形区域释放4发霞弹 每发造成0.3 / 0.35 / 0.4的物理攻击力伤害
        反坦克炮
        发射一枚携带爆炸火药的反坦克炮
        造成1 / 1.5 /2的魔法攻击力伤害
        击退敌人1米后爆炸 对周围收到伤害的敌人造成魔法伤害
        造成1 / 1.5 /2的魔法攻击力伤害
        距离爆炸中心越近的敌人收到的伤害越高
        并且眩晕所有收到爆炸效果的敌人
        距离爆炸中心越近眩晕时间越长
        爆炸半径5
        距离中心伤害率150% 80%
        距离中心眩晕时间2 ~ 0.5
        爆炸半径5
        距离中心伤害率150% 80%
        距离中心眩晕时间2 ~ 0.5
        爆炸半径5
        距离中心伤害率150% 80%
        距离中心眩晕时间2 ~ 0.5
        反坦克炮的普通攻击可以有几率 眩晕敌人
        15% 眩晕1秒
        25%  眩晕1.25秒
        35%  眩晕1.5秒
        镭射激光炮
        像前方发射一束高能镭射炮 可以击穿敌人 造成1的魔法攻击力伤害命中敌人后会在敌人身上产生镭射残留 持续3 /4 /5秒, 被镭射的敌人会受到辐射伤害 每秒 2% /3%  /4%的最大生命值的魔法伤害
        激光镭射炮的普通攻击收到激光能量的影响 在MP为0%到100%的时候 造成0.7 / 0.8 /0.9到1.4 /1.6 /1.8物理攻击力伤害
        电磁脉冲炮
        发射一枚过载电磁脉冲炮 会在被击中的敌人位置产生一个电磁脉冲圈  每1秒 脉冲中心会将周围敌人拉向中心 造成0.4 / 0.5 /0.6的魔法攻击力伤害 持续3秒
        电磁脉冲炮会从空气中吸收脉冲残留 每秒回复2% /4% /6% 的已损失的MP
        聚焦火能枪
        聚焦火能达到最大功率 能量束将击穿当前敌人并且一直延伸到射程最远距离 对能量束经过的敌人造成当前高频的魔法伤害 伤害频率为当前攻击频率 每次造成0.1 / 0.15 /0.2的魔法伤害
        聚焦火能枪的普通攻击为无间断攻击 攻速提升会提高普通攻击的伤害频率
        在MP为0%到100%的时候 造成0.7 / 0.8 /0.9到1.4 /1.6 /1.8物理攻击力伤害
        三菱光镜塔
        光棱镜能量达到上限 向前,左后,右后方向释放高能光束 长度为2 ,随射程提升而提升 然后顺时针旋转 转速随攻速提高而提高 持续2.5 / 3 / 3.5秒钟
        三菱光镜塔的普通攻击命中后 会向敌人周围等边三角形顶点方向 衍射出3道长度为2 激光 可以穿透  对激光穿过的敌人造成0.2的物理攻击力伤害
        Gz-560激光发射器
        请求GZ激光卫星支援 10秒内 每当一名敌人被GZ560激光发射器命中 激光卫星会为命中的敌人进行远程打击 0.5秒后收到远程激光打击 造成0.2的魔法攻击力伤害
        激光发射器的普攻会延伸至无穷远 对后续敌人的伤害为递减10% 最多递减50%
        羽刃塔
        羽刃塔的普通攻击在穿透最后一名敌人后会将羽刃留在地上 每次经过的敌人会受到0.2的魔法攻击力伤害
        羽刃塔召唤所有插在地上的羽刃回到自身 每一支羽刃对经过的敌人造成0.3 / 0.5 /0.7的魔法攻击力伤害 如果敌人被3支羽刃穿过 则会禁锢敌人2秒
*/
