import Helper as h

def loadPrimFromFile(file):
    #we need the number of nodes. Stored in n
    fi=open(file,"r")
    n=int(fi.readline())
    m=h.createMatrix(n,0)
    i=0
    for line in fi:
        list=line.strip().split(",")
        k=0
        for j in range(i+1,n):
            m[i][j]=int(list[k])
            k=k+1
        i=i+1
    fi.close()
    return m,n


def initPrim(nodesCost, paths, visited, n):
    paths[0] = -1
    nodesCost[0] = 0 #The first node is the starting point
    for i in range(n):
        visited[i] = False
    
    return nodesCost, paths, visited

def minNodeIndex(nodesCost, visited, n):
    minCost = float('inf')
    retNodeIndex = float('inf')

    for i in range(n):
        if((visited[i] == False) and (nodesCost[i] < minCost) and
            (minCost > 0) and (minCost > 0)):
            minCost = nodesCost[i]
            retNodeIndex = i
    return retNodeIndex


def prim(nodes, n):
    nodesFinalCost = [float('inf')]*n
    paths = [float]*n
    visited = [False]*n
    cost = 0

    nodesFinalCost, paths, visited = initPrim(nodesFinalCost, paths, visited, n)

    for i in range(n):
        init_node_index = minNodeIndex(nodesFinalCost, visited, n)
        visited[init_node_index] = True
        for objective_node_index in range(n):

            if((visited[objective_node_index] == False) and 
            (nodes[init_node_index][objective_node_index] > 0)
            and (nodesFinalCost[objective_node_index] > nodes[init_node_index][objective_node_index])):
            #if not visited, cost > 0 (it is not a valid cost) and the path to the objective node is 
            #greater than another we can find set the less cost value
                nodesFinalCost[objective_node_index] = nodes[init_node_index][objective_node_index]
                paths[objective_node_index] = init_node_index

    #sum the total cost
    for i in nodesFinalCost:
        cost += i
    
    printPrimFormat(cost)

    return cost, paths





def printPrimFormat(total_cost):
    print("TOTAL COST: " + str(total_cost))


def main():
    file_name = input("Enter the name of the file: ")
    nodes, n = loadPrimFromFile(file_name)
    total_cost, paths = prim(nodes, n)
    printPrimFormat(total_cost)


