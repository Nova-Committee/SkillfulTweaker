package committee.nova.skillfultweaker.compat.expansion;

import committee.nova.skillful.util.Utilities;
import committee.nova.skillfultweaker.compat.skill.objects.Skill;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
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

    @ZenMethod
    public static void clearSkillInfoCache(IPlayer player) {
        final EntityPlayer p = CraftTweakerMC.getPlayer(player);
        if (!(p instanceof EntityPlayerMP)) return;
        final MinecraftServer server = p.getServer();
        if (server == null) return;
        server.commandManager.executeCommand(p, "/skillful clearinfo");
    }
}
