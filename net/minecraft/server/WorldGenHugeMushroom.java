package net.minecraft.server;

import java.util.Random;

public class WorldGenHugeMushroom extends WorldGenerator {

    private int a = -1;

    public WorldGenHugeMushroom(int i) {
        super(true);
        this.a = i;
    }

    public WorldGenHugeMushroom() {
        super(false);
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        int l = random.nextInt(2);

        if (this.a >= 0) {
            l = this.a;
        }

        int i1 = random.nextInt(3) + 4;
        boolean flag = true;

        if (j >= 1 && j + i1 + 1 < 256) {
            int j1;
            int k1;
            int l1;
            int i2;

            for (j1 = j; j1 <= j + 1 + i1; ++j1) {
                byte b0 = 3;

                if (j1 <= j + 3) {
                    b0 = 0;
                }

                for (k1 = i - b0; k1 <= i + b0 && flag; ++k1) {
                    for (l1 = k - b0; l1 <= k + b0 && flag; ++l1) {
                        if (j1 >= 0 && j1 < 256) {
                            i2 = world.getTypeId(k1, j1, l1);
                            if (i2 != 0 && i2 != Block.LEAVES.id) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                j1 = world.getTypeId(i, j - 1, k);
                if (j1 != Block.DIRT.id && j1 != Block.GRASS.id && j1 != Block.MYCEL.id) {
                    return false;
                } else {
                    int j2 = j + i1;

                    if (l == 1) {
                        j2 = j + i1 - 3;
                    }

                    for (k1 = j2; k1 <= j + i1; ++k1) {
                        l1 = 1;
                        if (k1 < j + i1) {
                            ++l1;
                        }

                        if (l == 0) {
                            l1 = 3;
                        }

                        for (i2 = i - l1; i2 <= i + l1; ++i2) {
                            for (int k2 = k - l1; k2 <= k + l1; ++k2) {
                                int l2 = 5;

                                if (i2 == i - l1) {
                                    --l2;
                                }

                                if (i2 == i + l1) {
                                    ++l2;
                                }

                                if (k2 == k - l1) {
                                    l2 -= 3;
                                }

                                if (k2 == k + l1) {
                                    l2 += 3;
                                }

                                if (l == 0 || k1 < j + i1) {
                                    if ((i2 == i - l1 || i2 == i + l1) && (k2 == k - l1 || k2 == k + l1)) {
                                        continue;
                                    }

                                    if (i2 == i - (l1 - 1) && k2 == k - l1) {
                                        l2 = 1;
                                    }

                                    if (i2 == i - l1 && k2 == k - (l1 - 1)) {
                                        l2 = 1;
                                    }

                                    if (i2 == i + (l1 - 1) && k2 == k - l1) {
                                        l2 = 3;
                                    }

                                    if (i2 == i + l1 && k2 == k - (l1 - 1)) {
                                        l2 = 3;
                                    }

                                    if (i2 == i - (l1 - 1) && k2 == k + l1) {
                                        l2 = 7;
                                    }

                                    if (i2 == i - l1 && k2 == k + (l1 - 1)) {
                                        l2 = 7;
                                    }

                                    if (i2 == i + (l1 - 1) && k2 == k + l1) {
                                        l2 = 9;
                                    }

                                    if (i2 == i + l1 && k2 == k + (l1 - 1)) {
                                        l2 = 9;
                                    }
                                }

                                if (l2 == 5 && k1 < j + i1) {
                                    l2 = 0;
                                }

                                if ((l2 != 0 || j >= j + i1 - 1) && !Block.n[world.getTypeId(i2, k1, k2)]) {
                                    this.setTypeAndData(world, i2, k1, k2, Block.BIG_MUSHROOM_1.id + l, l2);
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < i1; ++k1) {
                        l1 = world.getTypeId(i, j + k1, k);
                        if (!Block.n[l1]) {
                            this.setTypeAndData(world, i, j + k1, k, Block.BIG_MUSHROOM_1.id + l, 10);
                        }
                    }

                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
