/* Data section */
	.section .data

	 .common b,4,4

	 .common a,4,4



/* Text section */
	.section .text
	.global main
	.type main,@function
main:
	 pushq %rbp
	 movq %rsp,%rbp
	 pushq %rbx
	 pushq %r12
	 pushq %r13
	 pushq %r14
	 pushq %r15
	 subq $8,%rsp

	 movl $1, %eax
	 movl %eax,a(%rip)
	 movl a(%rip), %ecx
	 movl $3, %edx
	 addl %edx, %ecx
	 movl %ecx,b(%rip)

	 addq $8,%rsp
	 popq %r15
	 popq %r14
	 popq %r13
	 popq %r12
	 popq %rbx
	 popq %rbp
	 ret
