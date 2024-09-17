下面是四种排序算法的时间复杂度分析：

### 冒泡排序
- **最佳情况**：如果输入的数据已经是有序的，则冒泡排序只需要遍历一次数组即可完成排序，时间复杂度为 O(n)。
- **平均情况**：每次遍历时都会比较相邻元素，并可能交换它们的位置，直到整个列表都排好序。因此，平均情况下时间复杂度为 O(n^2)。
- **最坏情况**：当输入的数据完全逆序时，冒泡排序将进行最多的比较和交换，时间复杂度为 O(n^2)。

### 堆排序
- **最佳情况**、**平均情况**、**最坏情况**：堆排序是一个比较稳定的排序算法，无论输入数据的情况如何，其时间复杂度都是 O(n log n)。这是因为构建初始堆的时间复杂度为 O(n)，而调整堆并取出最大/最小值的操作需要执行 n 次，每次调整堆的时间复杂度为 O(log n)。

### 快速排序
- **最佳情况**：如果每次都能选择到一个完美的基准值，那么快速排序可以在每次划分后都将数组分为几乎相等的两部分，此时的时间复杂度为 O(n log n)。
- **平均情况**：快速排序的平均时间复杂度也是 O(n log n)。
- **最坏情况**：如果每次选择的基准值都很糟糕，导致每次划分只能分割掉一个元素，那么时间复杂度会退化为 O(n^2)。这种情况可以通过随机选取基准值来避免。

### 归并排序
- **最佳情况**、**平均情况**、**最坏情况**：归并排序是一种稳定的排序算法，它通过不断将数组分成更小的部分，然后再将这些部分合并成有序的数组。由于每次合并操作都需要遍历整个数组，且数组被分成对数级别的层次，所以归并排序的时间复杂度始终是 O(n log n)。

总的来说，对于大规模数据集，归并排序和堆排序以及快速排序通常比冒泡排序更为高效，因为它们具有更好的平均和最坏情况性能。但是，在某些特定情况下，比如数据接近有序时，冒泡排序可能会表现出较好的性能。快速排序通常被认为是最快的通用排序算法之一，但在极端情况下可能不如其他算法稳定。