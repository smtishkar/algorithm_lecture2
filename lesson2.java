import java.util.Arrays;

/**
 * lesson2
 */
public class lesson2 {

    public static void main(String[] args) {

        int[] array = { 1, 4, 3, 27, 34, 15, 55};
        System.out.println(Arrays.toString(array));
        heapify(array, array.length, 0);
        // System.out.println(Arrays.toString(array));
        // sort(array);
        // System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);
        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Вызываем процедуру heapif на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2*rootIndex + 1
        int rightChild = 2 * rootIndex + 2;
        System.out.println(" root " + rootIndex + " largest " + largest + " left " + leftChild + " right " + rightChild);
        // правый = 2*rootIndex + 2
        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            System.out.println(Arrays.toString(array));
            System.out.println(" root " + rootIndex + " largest " + largest);
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }

    }
}