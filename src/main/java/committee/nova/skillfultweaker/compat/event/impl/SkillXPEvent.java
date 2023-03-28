package committee.nova.skillfultweaker.compat.event.impl;

import committee.nova.skillful.event.impl.SkillXpEvent;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("skillful.event.skill.xp.Base")
public class SkillXPEvent extends SkillEvent {
    private final SkillXpEvent event;

    public SkillXPEvent(committee.nova.skillful.event.impl.SkillXpEvent event) {
        super(event);
        this.event = event;
    }

    @ZenGetter("amount")
    public int getAmount() {
        return event.getAmount();
    }
}
