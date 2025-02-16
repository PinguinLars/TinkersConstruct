package slimeknights.tconstruct.smeltery.block.entity.tank;

import net.minecraft.core.BlockPos;
import net.minecraftforge.client.model.data.ModelProperty;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

/**
 * Interface for blocks to be notified when the smeltery has a new bottommost fluid
 */
public interface IDisplayFluidListener {
  /** Property for fluid models TODO: move to {@link slimeknights.tconstruct.library.client.model.ModelProperties} */
  ModelProperty<FluidStack> PROPERTY = new ModelProperty<>();

  /**
   * Called when the display fluid changes0
   * @param fluid New display fluid, is safe to store (will not be modified)
   */
  void notifyDisplayFluidUpdated(FluidStack fluid);

  /**
   * Gets the position of the listener.
   * @return  Position of listener
   * @deprecated Will be removed in 1.20.1 as its no longer needed. Block entity controller shouldn't rely on position equivalence to compare listeners anymore.
   */
  @Deprecated
  @OverrideOnly
  BlockPos getListenerPos();

  /** Makes the fluid contain 1000mb, or {@link FluidStack#EMPTY} if empty */
  static FluidStack normalizeFluid(FluidStack fluid) {
    if (fluid.isEmpty()) {
      return FluidStack.EMPTY;
    }
    fluid = fluid.copy();
    fluid.setAmount(FluidType.BUCKET_VOLUME);
    return fluid;
  }
}
