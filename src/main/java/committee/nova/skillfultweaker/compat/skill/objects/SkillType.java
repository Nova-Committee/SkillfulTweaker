package committee.nova.skillfultweaker.compat.skill.objects;

import committee.nova.skillful.api.skill.ISkill;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.skill.SkillType")
public class SkillType {
    private final ISkill skill;

    public SkillType(ISkill skill) {
        this.skill = skill;
    }

    @ZenGetter("maxLevel")
    public int getMaxLevel() {
        return skill.getMaxLevel();
    }

    @ZenMethod
    public int getLevelRequiredXP(int targetLevel) {
        return skill.getLevelRequiredXp(targetLevel);
    }

    @ZenGetter("id")
    public String getId() {
        return skill.getId().toString();
    }

    public ISkill getSkill() {
        return skill;
    }
}
