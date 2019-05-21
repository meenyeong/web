package vo;

public class Project {

   private int pnum;
   private String id;
   private String subject;
   private String contents;
   private String category;
   private int goal;
   private String date_start;
   private String date_fin;
   private String image;
   private String date_req;
   private int pick;
   
   
   
   public int getPick() {
	return pick;
}

public void setPick(int pick) {
	this.pick = pick;
}

public Project(int pnum, String id, String subject, String contents, String category, int goal, String date_start,
         String date_fin, String image, String date_req) {
      super();
      this.pnum = pnum;
      this.id = id;
      this.subject = subject;
      this.contents = contents;
      this.category = category;
      this.goal = goal;
      this.date_start = date_start;
      this.date_fin = date_fin;
      this.image = image;
      this.date_req = date_req;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public int getPnum() {
      return pnum;
   }

   public void setPnum(int pnum) {
      this.pnum = pnum;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public int getGoal() {
      return goal;
   }

   public void setGoal(int goal) {
      this.goal = goal;
   }

   public String getDate_start() {
      return date_start;
   }

   public void setDate_start(String date_start) {
      this.date_start = date_start;
   }

   public String getDate_fin() {
      return date_fin;
   }

   public void setDate_fin(String date_fin) {
      this.date_fin = date_fin;
   }

   public String getDate_req() {
      return date_req;
   }

   public void setDate_req(String date_req) {
      this.date_req = date_req;
   }

public Project(int pnum, String id, String subject) {
	super();
	this.pnum = pnum;
	this.id = id;
	this.subject = subject;
}

   
}