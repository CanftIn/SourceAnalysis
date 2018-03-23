	.file	"code.c"
	.text
	.globl	_sum
	.def	_sum;	.scl	2;	.type	32;	.endef
_sum:
	movl	8(%esp), %eax
	addl	4(%esp), %eax
	addl	%eax, _acccum
	ret
	.globl	_acccum
	.bss
	.align 4
_acccum:
	.space 4
	.ident	"GCC: (GNU) 7.1.0"
