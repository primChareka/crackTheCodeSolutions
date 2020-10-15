counter = 0
s = 'abc'
output = ''
prev = s[0]

for c in s:
    if(c is not prev):
        if(counter>1):
            output+=prev+str(counter)
        else :
            output+=prev
        prev=c
        counter=1
    else:
        counter+=1

if counter > 1:
    output+=c+str(counter)
else:
    output+=c

print(output)
