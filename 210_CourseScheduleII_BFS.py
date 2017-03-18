import Queue


class Solution(object):

    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        adjx = [[] for x in range(numCourses)]
        adjNumbers = [0] * numCourses
        for preq in prerequisites:
            adjx[preq[1]].append(preq[0])
            adjNumbers[preq[0]] += 1

        # put prerequisites number = 0 's node to queue
        q = Queue.Queue()
        for i in range(numCourses):
            if adjNumbers[i] == 0:
                q.put(i)

        result = []

        while not q.empty():
            course = q.get()
            result.append(course)

            for after in adjx[course]:
                adjNumbers[after] -= 1
                if adjNumbers[after] == 0:
                    q.put(after)

        return result if len(result) == numCourses else []

