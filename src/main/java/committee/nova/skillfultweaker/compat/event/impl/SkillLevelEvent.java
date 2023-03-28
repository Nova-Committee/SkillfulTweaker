package committee.nova.skillfultweaker.compat.event.impl;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.event.skill.lvl.SkillLevelEvent")
public class SkillLevelEvent extends SkillEvent {
    private final committee.nova.skillful.event.impl.SkillLevelEvent event;

    public SkillLevelEvent(committee.nova.skillful.event.impl.SkillLevelEvent event) {
        super(event);
        this.event = event;
    }

    @ZenGetter("level")
    public int getLevel() {
        return event.getCurrentLevel();
    }

    @ZenMethod
    public boolean isUp() {
        return event.isUp();
    }

    @ZenMethod
    public boolean isDown() {
        return event.isDown();
    }
}
