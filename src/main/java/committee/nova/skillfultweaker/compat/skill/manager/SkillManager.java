package committee.nova.skillfultweaker.compat.skill.manager;

import committee.nova.skillful.api.skill.ISkill;
import committee.nova.skillful.storage.SkillfulStorage;
import committee.nova.skillfultweaker.compat.skill.objects.SkillType;
import crafttweaker.annotations.ZenRegister;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.skill.SkillManager")
public class SkillManager {
    public static final SkillManager INSTANCE = new SkillManager();

    @ZenMethod
    public static SkillManager getInstance() {
        return INSTANCE;
    }

    @ZenMethod
    public SkillType[] getSkillTypes() {
        final ISkill[] skills = SkillfulStorage.getSkills();
        final int size = skills.length;
        final SkillType[] types = new SkillType[size + 1];
        for (int i = 0; i < size; i++) types[i] = new SkillType(skills[i]);
        return types;
    }

    @ZenMethod
    public SkillType getSkillType(String id) {
        return new SkillType(SkillfulStorage.getSkill(new ResourceLocation(id.contains(":") ? id : "crt:" + id)));
    }
}
