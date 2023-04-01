package committee.nova.skillfultweaker.compat.funcs;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ZenClass("skillful.func.ILevelRequiredXp")
public interface ILevelRequiredXp {
    int getRequired(int level);
}
