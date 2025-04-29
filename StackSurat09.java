public class StackSurat09 {
    Surat09[] stack;
    int top;
    int size;

    public StackSurat09(int size) {
        this.size = size;
        stack = new Surat09[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat09 s) {
        if (!isFull()) {
            top = top + 1;
            stack[top] = s;
            System.out.println("Surat berhasil diterima.");
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat baru.");
        }
    }

    public Surat09 pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang bisa diproses.");
            return null;
        }
    }

    public Surat09 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    public void searchByNama(String nama) {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                found = true;
                System.out.println("Surat ditemukan: ID " + stack[i].idSurat + ", Kelas " + stack[i].kelas + ", Jenis Izin: " + stack[i].jenisIzin + ", Durasi: " + stack[i].durasi + " hari");
            }
        }
        if (!found) {
            System.out.println("Surat atas nama " + nama + " tidak ditemukan.");
        }
    }
}
