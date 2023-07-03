public class Main {
    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator(1_000_000);
        calculator.calculateValues();
    }

    public static class ValueCalculator {
        private float[] array;
        private int size;
        private int halfSize;

        public ValueCalculator(int size) {
            this.size = Math.max(size, 1_000_000);
            this.halfSize = this.size / 2;
            this.array = new float[this.size];
        }

        public void calculateValues() {
            long start = System.currentTimeMillis();


            float value = 1.0f;
            for (int i = 0; i < size; i++) {
                array[i] = value;
            }


            float[] array1 = new float[halfSize];
            float[] array2 = new float[halfSize];
            System.arraycopy(array, 0, array1, 0, halfSize);
            System.arraycopy(array, halfSize, array2, 0, halfSize);


            Thread thread1 = new Thread(() -> {
                calculateNewValues(array1, 0);
            });

            Thread thread2 = new Thread(() -> {
                calculateNewValues(array2, halfSize);
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.arraycopy(array1, 0, array, 0, halfSize);
            System.arraycopy(array2, 0, array, halfSize, halfSize);

            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println("Час витрачений до завершення програми : " + elapsedTime + " мс");
        }

        private void calculateNewValues(float[] arr, int offset) {
            for (int i = 0; i < arr.length; i++) {
                int index = i + offset;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
            }
        }
    }
}