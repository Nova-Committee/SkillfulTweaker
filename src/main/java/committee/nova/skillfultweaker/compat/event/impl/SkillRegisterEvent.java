package committee.nova.skillfultweaker.compat.event.impl;

import committee.nova.skillful.storage.SkillfulStorage;
import committee.nova.skillfultweaker.compat.skill.objects.SkillType;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.event.skill.registry.SkillRegisterEvent")
public class SkillRegisterEvent {
    private final SkillfulStorage.SkillRegisterEvent event;

    public SkillRegisterEvent(SkillfulStorage.SkillRegisterEvent event) {
        this.event = event;
    }

    @ZenMethod
    public void addSkill(SkillType skill) {
        event.addSkill(skill.getSkill());
    }
}
