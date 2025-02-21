DESCRIPTION = "Minimal initramfs image for Tegra platforms"
LICENSE = "MIT"

# Prevent the annoying "Manifest" error for x86_64_x86_64_native-nativesdk...
deltask do_packagedata

TEGRA_INITRD_INSTALL ??= ""
INITRD_FSTYPES ??= "${INITRAMFS_FSTYPES}"

TEGRA_INITRD_BASEUTILS ?= "busybox"

PACKAGE_INSTALL = "\
    tegra-firmware-xusb \
    tegra-minimal-init-live.blob \
    xz tar boot-tmr \
    e2fsprogs-e2fsck e2fsprogs-mke2fs e2fsprogs-tune2fs e2fsprogs-badblocks e2fsprogs-resize2fs \
    ${TEGRA_INITRD_BASEUTILS} \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    ${TEGRA_INITRD_INSTALL} \
"

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""

COPY_LIC_MANIFEST = "0"
COPY_LIC_DIRS = "0"

COMPATIBLE_MACHINE = "(tegra)"

KERNELDEPMODDEPEND = ""

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

FORCE_RO_REMOVE ?= "1"

inherit core-image

IMAGE_FSTYPES = "${INITRD_FSTYPES}"
