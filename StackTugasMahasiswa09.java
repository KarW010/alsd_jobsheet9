public class StackTugasMahasiswa09 {
    Mahasiswa09[] stack;
    int top;
    int size;

    public StackTugasMahasiswa09(int size){
        this.size = size;
        stack = new Mahasiswa09[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa09 mhs){
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    public Mahasiswa09 pop() {
        if (!isEmpty()) {
            Mahasiswa09 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    public Mahasiswa09 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }

    public void print() {
        Mahasiswa09[] tempStack = new Mahasiswa09[top + 1];
        for (int i = 0; i <= top; i++) {
        tempStack[i] = stack[i];
        }

        for (int i = 0; i < tempStack.length - 1; i++) {
            for (int j = i + 1; j < tempStack.length; j++) {
                int nimI = Integer.parseInt(tempStack[i].nim);
                int nimJ = Integer.parseInt(tempStack[j].nim);
                if (nimI < nimJ) {
                    Mahasiswa09 temp = tempStack[i];
                    tempStack[i] = tempStack[j];
                    tempStack[j] = temp;
                }
            }
        }

        for (Mahasiswa09 m : tempStack) {
            System.out.println(m.nama + "\t" + m.nim + "\t" + m.kelas);
        }
        System.out.println();
    }
}