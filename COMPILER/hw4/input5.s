/* Data section */
	.section .data

	 .common a,12,4

L1:
	 .string "assign 1 to a[0]\n"
L2:
	 .string "The next line will show the value in a[0]\n"
L3:
	 .string "%d\n"
L4:
	 .string "assign 10 to a[1]\n"
L5:
	 .string "The next line will show the value in a[1]\n"
L6:
	 .string "%d\n"
L7:
	 .string "assign 1 to a[2]\n"
L8:
	 .string "The next line will show the value in a[2]\n"
L9:
	 .string "%d\n"
L10:
	 .string ""


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
	 movq $L1,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L2,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %ecx
	 movl a(%rip), %esi
	 movq $L3,%rdi
	 xor %rax, %rax
	 call printf
	 movl $10, %edx
	 movl %edx,a(%rip)
	 movq $L4,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L5,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %ebx
	 movl a(%rip), %esi
	 movq $L6,%rdi
	 xor %rax, %rax
	 call printf
	 movl $100, %r8d
	 movl %r8d,a(%rip)
	 movq $L7,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L8,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %r9d
	 movl a(%rip), %esi
	 movq $L9,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L10,%rdi
	 xor %rax, %rax
	 call printf

	 addq $8,%rsp
	 popq %r15
	 popq %r14
	 popq %r13
	 popq %r12
	 popq %rbx
	 popq %rbp
	 ret
