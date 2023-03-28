package committee.nova.skillfultweaker.compat.skill.objects;

import committee.nova.skillful.impl.skill.SkillBuilder;
import crafttweaker.annotations.ZenRegister;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.skill.SkillTypeBuilder")
public class SkillTypeBuilder {
    private final SkillBuilder builder;

    private SkillTypeBuilder(ResourceLocation id) {
        this.builder = SkillBuilder.create(id).setLevelRequiredXP((int i) -> i * 10000);
    }

    @ZenMethod
    public static SkillTypeBuilder create(String id) {
        return new SkillTypeBuilder(new ResourceLocation(id.contains(":") ? id : "crt:" + id));
    }

    @ZenMethod
    public SkillTypeBuilder setMaxLevel(int maxLevel) {
        builder.setMaxLevel(maxLevel);
        return this;
    }

    @ZenMethod
    public SkillTypeBuilder setColor(String color) {
        BossInfo.Color c = BossInfo.Color.PINK;
        switch (color.toLowerCase()) {
            case "blue": {
                c = BossInfo.Color.BLUE;
                break;
            }
            case "red": {
                c = BossInfo.Color.RED;
                break;
            }
            case "green": {
                c = BossInfo.Color.GREEN;
                break;
            }
            case "yellow": {
                c = BossInfo.Color.YELLOW;
                break;
            }
            case "purple": {
                c = BossInfo.Color.PURPLE;
                break;
            }
            case "white": {
                c = BossInfo.Color.WHITE;
                break;
            }
            default:
        }
        builder.setColor(c);
        return this;
    }

    @ZenMethod
    public SkillType build() {
        return new SkillType(builder.build());
    }
}
