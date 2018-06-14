package makes.flint.doppel.doppelState.backgroundproviders

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import makes.flint.doppel.doppelState.backgroundproviders.backgroundconvenience.DoppelColors
import makes.flint.doppel.doppelState.backgroundproviders.drawables.DoppelColorDrawable

/**
 * DoppelColorDrawablesProvider
 */
class DoppelColorDrawablesProvider(context: Context, private val colors: List<Int> = DoppelColors.GRAYS(context)) : DoppelBackgroundProvider {

    private var animationSpeed = 1000L
    private var minAlpha = 0.3f
    private var maxAlpha = 1f
    private var radius = 0f

    override fun getBackgroundFor(view: View, layer: Int, depth: Int): Drawable {
        val color = getColorFor(layer, depth)
        return DoppelColorDrawable(color, animationSpeed, minAlpha, maxAlpha, radius)
    }

    fun setAnimationSpeed(speedMs: Long) {
        animationSpeed = speedMs
    }

    fun setMinAlpha(alpha: Float) {
        if (alpha < 0f) {
            minAlpha = 0f
            return
        }
        minAlpha = alpha
    }

    fun setMaxAlpha(alpha: Float) {
        if (alpha > 1f) {
            minAlpha = 1f
            return
        }
        maxAlpha = alpha
    }

    fun setCornerRadius(radiusPixels: Float) {
        radius = radiusPixels
    }

    private fun getColorFor(layer: Int, depth: Int): Int {
        if (layer > colors.size) {
            return colors.first()
        }
        return colors[layer - 1]
    }
}
