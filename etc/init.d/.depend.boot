TARGETS = mountkernfs.sh hostname.sh x11-common mountdevsubfs.sh qemu-kvm procps urandom hwclock.sh checkroot.sh networking mountnfs-bootclean.sh mountnfs.sh bootmisc.sh mountall-bootclean.sh mountall.sh checkroot-bootclean.sh checkfs.sh
INTERACTIVE = checkroot.sh checkfs.sh
mountdevsubfs.sh: mountkernfs.sh
qemu-kvm: mountkernfs.sh
procps: mountkernfs.sh
urandom: hwclock.sh
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
networking: mountkernfs.sh urandom procps
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
bootmisc.sh: mountnfs-bootclean.sh mountall-bootclean.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
checkroot-bootclean.sh: checkroot.sh
checkfs.sh: checkroot.sh
