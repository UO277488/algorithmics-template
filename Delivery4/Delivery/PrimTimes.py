import time as t
import Helper as h
import Prim as p

def PrimTimes():
    i = 256 #init value table
    print("n\t\ttime")
    while (i < float('inf')):
        nodes = h.triangularMatrixRandomIntegers(i,100,1000)
        print("------------" + str(i) + "------------")

        t1 = t.time()
        p.prim(nodes, i)
        t2 = t.time()
        
        print(str(t2-t1))
        
        i *= 2

def main():
    PrimTimes()

main()