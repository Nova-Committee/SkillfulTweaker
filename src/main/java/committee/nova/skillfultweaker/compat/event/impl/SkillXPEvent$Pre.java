package committee.nova.skillfultweaker.compat.event.impl;

import committee.nova.skillful.event.impl.SkillXpEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("skillful.event.skill.xp.SkillXPPreEvent")
public class SkillXPEvent$Pre extends SkillXPEvent implements IEventCancelable {
    private final SkillXpEvent.Pre event;

    public SkillXPEvent$Pre(SkillXpEvent.Pre event) {
        super(event);
        this.event = event;
    }

    @ZenSetter("amount")
    public void setAmount(int amount) {
        event.setAmount(amount);
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCanceled(canceled);
    }
}
