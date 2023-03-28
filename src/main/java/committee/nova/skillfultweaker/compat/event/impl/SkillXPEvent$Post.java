package committee.nova.skillfultweaker.compat.event.impl;

import committee.nova.skillful.event.impl.SkillXpEvent;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ZenClass("skillful.event.skill.xp.SkillXPPostEvent")
public class SkillXPEvent$Post extends SkillXPEvent {
    public SkillXPEvent$Post(SkillXpEvent.Post event) {
        super(event);
    }
}
