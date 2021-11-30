/**
 * The complete Basic Model Interface (BMI) in Java.
 */
package edu.colorado.csdms.bmi;

/**
 * The Basic Model Interface (BMI) is a standard for querying, modifying,
 * running and coupling models.
 * <p>
 * See the <a href="https://bmi.readthedocs.io">documentation</a> for more
 * information about BMI.
 */
public interface BMI extends BmiControl, BmiInfo, BmiVars, BmiTime, BmiGetter,
    BmiSetter, BmiGrid, BmiGridUniformRectilinear, BmiGridRectilinear,
    BmiGridStructuredQuad, BmiGridUnstructured {
}
