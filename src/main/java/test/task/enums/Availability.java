package test.task.enums;


public enum Availability {
        NO(0), FEW(1), LOTS(2);

        private int id;

        Availability(int id) {
                this.id = id;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }
}
