/* Data section */
	.section .data

	 .common f,4,4

	 .common e,4,4

	 .common d,4,4

L1:
	 .string "assing 2 to local variable d\n"
L2:
	 .string "assing 4 to local variable e\n"
L3:
	 .string "the next line will show local variable d\n"
L4:
	 .string "%d\n"
L5:
	 .string "the next line will show local variable e\n"
L6:
	 .string "%d\n"
L7:
	 .string "the next line show local variable f which is d*e\n"
L8:
	 .string "%d\n"
L9:
	 .string "the next line show local variable c which is e/d\n"
L10:
	 .string "%d\n"
L11:
	 .string "2\n"
L12:
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

	 movl $2, %eax
	 movl %eax,d(%rip)
	 movl $4, %ecx
	 movl %ecx,e(%rip)
	 movq $L1,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L2,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L3,%rdi
	 xor %rax, %rax
	 call printf
	 movl d(%rip), %edx
	 movl d(%rip), %esi
	 movq $L4,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L5,%rdi
	 xor %rax, %rax
	 call printf
	 movl e(%rip), %ebx
	 movl e(%rip), %esi
	 movq $L6,%rdi
	 xor %rax, %rax
	 call printf
	 movl d(%rip), %r8d
	 movl e(%rip), %r9d
	 imul %r9d, %r8d
	 movl %r8d,f(%rip)
	 movq $L7,%rdi
	 xor %rax, %rax
	 call printf
	 movl f(%rip), %r10d
	 movl f(%rip), %esi
	 movq $L8,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L9,%rdi
	 xor %rax, %rax
	 call printf
	 movl f(%rip), %r11d
	 movl f(%rip), %esi
	 movq $L10,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L11,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L12,%rdi
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
