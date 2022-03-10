export function getPascalsTriangleRow(rowNumber) {
    const arr =[]
    for(let i=0;i<=rowNumber;i++)
        {
            arr[i]=new Array(i)
            arr[i][0]=1;
            arr[i][i]=1
            for(let j=1;j<i;j++)
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j]
            
        }
    return arr.pop()
}