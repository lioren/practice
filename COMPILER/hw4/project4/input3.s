/* Data section */
	.section .data

	 .common c,4,4

	 .common b,4,4

	 .common a,4,4

L1:
	 .string "assing 1 to local variable a\n"
L2:
	 .string "assing 2 to local variable b\n"
L3:
	 .string "the next line will show local variable a\n"
L4:
	 .string "%d\n"
L5:
	 .string "the next line will show local variable b\n"
L6:
	 .string "%d\n"
L7:
	 .string "the next line show local variable c which is a+b\n"
L8:
	 .string "%d\n"
L9:
	 .string "the next line show local variable c which is a-b\n"
L10:
	 .string "%d\n"
L11:
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
	 movl $2, %ecx
	 movl %ecx,b(%rip)
	 movq $L1,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L2,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L3,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %edx
	 movl a(%rip), %esi
	 movq $L4,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L5,%rdi
	 xor %rax, %rax
	 call printf
	 movl b(%rip), %ebx
	 movl b(%rip), %esi
	 movq $L6,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %r8d
	 movl b(%rip), %r9d
	 addl %r9d, %r8d
	 movl %r8d,c(%rip)
	 movq $L7,%rdi
	 xor %rax, %rax
	 call printf
	 movl c(%rip), %r10d
	 movl c(%rip), %esi
	 movq $L8,%rdi
	 xor %rax, %rax
	 call printf
	 movl a(%rip), %r11d
	 movl b(%rip), %r12d
	 subl %r12d, %r11d
	 movl %r11d,c(%rip)
	 movq $L9,%rdi
	 xor %rax, %rax
	 call printf
	 movl c(%rip), %r13d
	 movl c(%rip), %esi
	 movq $L10,%rdi
	 xor %rax, %rax
	 call printf
	 movq $L11,%rdi
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
