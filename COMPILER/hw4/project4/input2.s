/* Data section */
	.section .data

	 .common f,4,4

	 .common e,4,4

	 .common d,4,4

L1:
	 .string "assign 8 to global variable d\n"
L2:
	 .string "assign 4 to global variable e\n"
L3:
	 .string "assign d*e to global variable f\n"
L4:
	 .string "next line will printf f\n"
L5:
	 .string "%d\n"
L6:
	 .string "assign d/e to global variable f\n"
L7:
	 .string "next line will printf f\n"
L8:
	 .string "2\n"
L9:
	 .string "next line will show (true)simple if statement\n"
L10:
	 .string "This line is true\n"
L11:
	 .string "next line will not show \"This line is false\"  because the next statement is false\n"
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

	 movl $8, %eax
	 movl %eax,d(%rip)
	 movl $4, %ecx
	 movl %ecx,e(%rip)
	 movq $L1,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L2,%rdi
	 xor %rax, %rax
	 call printf
	 movl d(%rip), %edx
	 movl e(%rip), %ebx
	 imul %ebx, %edx
	 movl %edx,f(%rip)
	 movq $L3,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L4,%rdi
	 xor %rax, %rax
	 call printf
	 movl f(%rip), %r8d
	 movl f(%rip), %esi
	 movq $L5,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L6,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L7,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L8,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L9,%rdi
	 xor %rax, %rax
	 call printf
	 movl $1, %r9d
	 movq $L10,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L11,%rdi
	 xor %rax, %rax
	 call printf
	 movl $0, %r10d
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
