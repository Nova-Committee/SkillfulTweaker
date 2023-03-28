package committee.nova.skillfultweaker.compat.expansion;

import committee.nova.skillful.util.Utilities;
import committee.nova.skillfultweaker.compat.skill.objects.Skill;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.player.IPlayer")
public class SkillfulPlayer {
    @ZenMethod
    public static Skill getSkillStat(IPlayer player, String id) {
        return new Skill(Utilities.getPlayerSkillStat(CraftTweakerMC.getPlayer(player), new ResourceLocation(id.contains(":") ? id : "crt:" + id)));
    }
}
