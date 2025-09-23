#include<stdio.h>
#define Max 5
int stack[Max];
int top=-1;
void push(int value){
if(top==Max-1){
printf("Stack overflow");
}
else{
top++;
stack[top]=value;
printf("%d pushed to stack\n",value);
}
}
void pop(){
if(top==-1){
printf("Stack underflow");
}
else{
printf("%d poped from stack\n",stack[top]);
top--;
}
}
void display(){
if(top==-1){
printf("stack is empty");
}
else{

printf("stack elements are: ");
for(int i=top;i>=0;i--){
printf("%d",stack[i]);
}
printf("\n");
}
}
int main(){
push(10);
push(20);
push(30);
display();
pop();
display();
push(40);
push(50);
push(60);
display();
return 0;
}
