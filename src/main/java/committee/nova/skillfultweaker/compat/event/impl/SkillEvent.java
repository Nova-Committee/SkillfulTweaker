package committee.nova.skillfultweaker.compat.event.impl;

import committee.nova.skillfultweaker.compat.skill.objects.Skill;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("skillful.event.skill.SkillEvent")
public class SkillEvent {
    private final committee.nova.skillful.event.impl.SkillEvent event;

    public SkillEvent(committee.nova.skillful.event.impl.SkillEvent event) {
        this.event = event;
    }

    @ZenGetter("skill")
    public Skill getSkill() {
        return new Skill(event.getSkillInstance());
    }

    @ZenGetter("player")
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getPlayer());
    }
}
