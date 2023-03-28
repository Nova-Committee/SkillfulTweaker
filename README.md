# Skillful Tweaker

## 概念和功能

SkillfulTweaker 是 Skillful 的 CraftTweaker 插件，目前能做到注册新技能、获取已注册技能、获取玩家特定技能学习程度、监听技能等级变化事件、监听/拦截技能经验变化事件。

## 常用类

### SkillType

#### 概念

技能类型类。对应 Skillful 代码中的 ISkill 类。

#### 导入

```java
import skillful.skill.SkillType;
```

#### 变量和函数

```scala
/**
技能类型的最大等级，存在 getter；
**/
val maxLevel: int

/**
技能类型的id，是由 ResourceLocation 转换而来，格式为“domain:path”；
**/
val id: string

/**
获取在某个等级下，该技能类型升级需要的经验值；
**/
def getLevelRequiredXP(level: int): int
```

### SkillTypeBuilder

#### 概念

技能类型的生成器类。对应 Skillful 代码中的 SkillBuilder 类。

#### 导入

```java
import skillful.skill.SkillTypeBuilder;
```

#### 变量和函数

```scala
/**
静态，构造一个 SkillTypeBuilder 实例，
id 是即将被生成的技能类型的标识符；
id 参数的标准格式是 “domain:path”，
如果参数中没有出现“:”，将被格式化为“crt:*”。
如 create("test") 最终生成的技能类型的 id 为 “crt:test”；
**/
def create(id: string): SkillTypeBuilder

/**
设置技能类型的最大等级，并返回 Builder；
**/
def setMaxLevel(maxLevel: int): SkillTypeBuilder

/**
设置技能类型的颜色（会影响技能经验条的颜色），并返回 Builder；
可选的颜色有：
"blue"、"red"、"green"、"yellow"、"purple"、"white"、"pink"；
默认为粉红色（"pink"）。
**/
def setColor(color: string): SkillTypeBuilder

/**
生成 SkillType；
**/
def build(): SkillType

/**
注：目前暂未实现指定技能类型升级时在每一级需要的经验。
默认为：需要经验 = 等级 * 10000；
**/
```

### Skill

#### 概念

技能实例类，能表现某个玩家对于某技能的学习程度。对应 Skillful 代码中的 SkillInstance 类。

#### 导入

```java
import skillful.skill.Skill;
```

#### 变量和函数

```scala
/**
技能实例承载的技能类型，存在 getter；
**/
val skillType: SkillType

/**
技能实例的当前等级，存在 getter；
**/
val level: int

/**
技能实例的当前经验值，存在 getter；
**/
val xp: int

/**
技能实例对应的技能类型是否已被学会，等价于 level > 0；
**/
def isAcquired(): bool

/**
技能实例的等级和经验值是否都为 0；
**/
def isClueless(): bool

/**
技能实例的等级是否已到达承载技能类型的最大等级；
**/
def isCompleted(): bool

/**
变动技能实例的经验；
**/
def changeXp(player: IPlayer, change: int): void

/**
技能实例等级、经验归零；
**/
def clear(player: IPlayer): void

/**
技能实例等级设置为技能类型最大等级，经验归零；
**/
def cheat(player: IPlayer): void
```

### SkillRegisterEvent

#### 概念

技能类型注册事件。

#### 导入

```java
import skillful.event.skill.registry.SkillRegisterEvent;
```

#### 变量和函数

```scala
/**
注册一个技能类型；
**/
def addSkill(skill: SkillType): void
```

### SkillLevelEvent

#### 概念

技能等级变动事件。

#### 导入

```java
import skillful.event.skill.lvl.SkillLevelEvent;
```

#### 变量和函数

```scala
/**
发生技能等级变动的玩家，存在 getter；
**/
val player: IPlayer

/**
对应的技能实例，存在 getter；
**/
val skill: Skill

/**
技能实例的当前等级，存在 getter；
**/
val level: int

/**
技能等级是否上升；
**/
def isUp(): bool

/**
技能等级是否下降；
**/
def isDown(): bool
```

### SkillXPPreEvent

#### 概念

技能经验变动前事件。 是一个可取消事件：取消后，技能经验不会变动。

#### 导入

```java
import skillful.event.skill.xp.SkillXPPreEvent;
```

#### 变量和函数

```scala
/**
发生技能经验变动的玩家，存在 getter；
**/
val player: IPlayer

/**
对应的技能实例，存在 getter；
**/
val skill: Skill

/**
技能经验变化量，存在 setter 和 getter；
**/
var amount: int
```

### SkillXPPostEvent

#### 概念

技能经验变动后事件。

#### 导入

```java
import skillful.event.skill.xp.SkillXPPostEvent;
```

#### 变量和函数

```scala
/**
发生技能经验变动的玩家，存在 getter；
**/
val player: IPlayer

/**
对应的技能实例，存在 getter；
**/
val skill: Skill

/**
技能经验变化量，存在 getter；
**/
val amount: int
```

### EventManager

#### 概念

Skillful 事件管理类。

#### 导入

```java
import skillful.event.EventManager;
```

#### 变量和函数

```scala
/**
静态，获取一个 EventManager 实例；
**/
def getInstance(): EventManager

/**
清除所有事件监听器；
**/
def clear(): void

/**
添加技能注册事件监听器；
**/
def onSkillRegister(event: function<SkillRegisterEvent>): void

/**
添加技能经验变动前事件监听器；
**/
def onSkillXPPre(event: function<SkillXPPreEvent>): void

/**
添加技能经验变动后事件监听器；
**/
def onSkillXPPost(event: function<SkillXPPostEvent>): void

/**
添加技能等级变动后事件监听器；
**/
def onSkillLevel(event: function<SkillLevelEvent>): void
```

### SkillManager

#### 概念

Skillful 管理类。

#### 导入

```java
import skillful.skill.SkillManager;
```

#### 变量和函数

```scala
/**
静态，获取一个 SkillManager 实例；
**/
def getInstance(): SkillManager

/**
获取所有目前已注册的技能类型；
**/
def getSkillTypes(): SkillType[]

/**
根据传入的 id，获取对应的技能类型；
如果并不存在符合条件的已有技能类型，
将当场注册一个 id 一致的假的技能类型（最大等级和每一级的升级所需经验值都为 2^15-1）并返回。
**/
def getSkillType(id: string): SkillType
```

## 扩展类

### IPlayer

#### 变量与函数

```scala
/**
根据传入的技能类型 id，获取玩家的相应技能实例；
**/
def getSkillStat(id: string): Skill
```

## 示例脚本

注册一个id为 “test:test” 的新技能，最大等级为 100，显示颜色为白色。 玩家破坏方块时，该技能获得 1 点经验。

```javascript
import skillful.event.EventManager;
import skillful.event.skill.registry.SkillRegisterEvent;
import skillful.skill.Skill;
import skillful.skill.SkillType;
import skillful.skill.SkillTypeBuilder;

import crafttweaker.events.IEventManager;
import crafttweaker.event.BlockBreakEvent;
import crafttweaker.player.IPlayer;

val manager as EventManager = EventManager.getInstance();

val testSkill as SkillType = SkillTypeBuilder.create("test:test")
.setMaxLevel(100).setColor("white").build();

manager.onSkillRegister(function(event as SkillRegisterEvent) {
    event.addSkill(testSkill);
});

events.onBlockBreak(function(event as BlockBreakEvent) {
    val player as IPlayer = event.player;
    player.getSkillStat("test:test").changeXp(player, 1);
});
```