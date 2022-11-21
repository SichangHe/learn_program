import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { 0.0625, 0.125, 0.0625 }, { 0.125, 0.25, 0.125 }, { 0.0625, 0.125, 0.0625 }
        };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int h = picture.height(), w = picture.width();
        double filteredRed, filteredGreen, filteredBlue;
        Picture pic = new Picture(w, h);
        Color tempColor;

        // special case when the picture is too small
        if (h < 4 || w < 4) {
            // go by every single pixel
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    filteredRed = 0;
                    filteredGreen = 0;
                    filteredBlue = 0;
                    // affect by neighbour pixels
                    for (int m = -4; m < 5; m++) {
                        tempColor = picture.get((m + i + 4 * w) % w, (m + j + 4 * h) % h);
                        filteredRed += tempColor.getRed() * 1.0 / 9;
                        filteredGreen += tempColor.getGreen() * 1.0 / 9;
                        filteredBlue += tempColor.getBlue() * 1.0 / 9;
                    }
                    pic.set(i, j, new Color(
                                    Math.max(
                                            0, Math.min(
                                                    255, (int) Math.round(filteredRed)
                                            )
                                    ),      // red
                                    Math.max(
                                            0, Math.min(
                                                    255, (int) Math.round(filteredGreen)
                                            )
                                    ),      // green
                                    Math.max(
                                            0, Math.min(
                                                    255, (int) Math.round(filteredBlue)
                                            )
                                    )
                            )
                    );

                }
            }

            return pic;

        }

        // go by every single pixel
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                filteredRed = 0;
                filteredGreen = 0;
                filteredBlue = 0;
                // affect by neighbour pixels
                for (int m = -4; m < 5; m++) {
                    tempColor = picture.get((m + i + w) % w, (m + j + h) % h);
                    filteredRed += tempColor.getRed() * 1.0 / 9;
                    filteredGreen += tempColor.getGreen() * 1.0 / 9;
                    filteredBlue += tempColor.getBlue() * 1.0 / 9;
                }
                pic.set(i, j, new Color(
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredRed)
                                        )
                                ),      // red
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredGreen)
                                        )
                                ),      // green
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredBlue)
                                        )
                                )
                        )
                );

            }
        }

        return pic;
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        int h = picture.height(), w = picture.width();
        double filteredRed, filteredGreen, filteredBlue;
        Picture pic = new Picture(w, h);
        Color tempColor;

        // go by every single pixel
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                filteredRed = 0;
                filteredGreen = 0;
                filteredBlue = 0;
                // affect by neighbour pixels
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        tempColor = picture.get((-1 + m + i + w) % w, (-1 + n + j + h) % h);
                        filteredRed += tempColor.getRed() * weights[n][m];
                        filteredGreen += tempColor.getGreen() * weights[n][m];
                        filteredBlue += tempColor.getBlue() * weights[n][m];
                    }
                }
                pic.set(i, j, new Color(
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredRed)
                                        )
                                ),      // red
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredGreen)
                                        )
                                ),      // green
                                Math.max(
                                        0, Math.min(
                                                255, (int) Math.round(filteredBlue)
                                        )
                                )
                        )
                );

            }
        }


        return pic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture("halfbaboon.png");
        Picture pic = emboss(picture);
        pic.show();
        pic = identity(picture);
        pic.show();
        pic = gaussian(picture);
        pic.show();
        pic = sharpen(picture);
        pic.show();
        pic = laplacian(picture);
        pic.show();
        pic = motionBlur(picture);
        pic.show();
    }
}
