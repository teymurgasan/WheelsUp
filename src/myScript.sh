mkdir myFiles
cd myFiles
touch file1.txt
cat file1.txt > file2.txt > file3.txt > file4.txt > file5.txt > file6.txt > file7.txt
ls -t | tail -n +4 | xargs rm --
cat >> file5.txt <<EOF
I'm file 5
EOF
cat >> file6.txt <<EOF
I'm file 6
EOF
cat >> file7.txt <<EOF
I'm file 7
EOF