import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 2020136129 최수연 
 * @file DrawSadFace.java
 * 과제 4. JavaFX: 여러 도형과 이미지를 이용하여 새 개체 정의하기
 */

/*
 * 슬픈얼굴을 만들 때 필요한 얼굴, 눈, 입, 눈물을 각각 도형으로 표현함.
 * 먼저 얼굴은 원으로 표현하였고, 각 face1, face2마다의 기준 좌표 xLeft, yTop 매개변수를 받아
 * 중심 x, y 좌표를 지정하고, 반지름을 100d로 설정함. 그리고 얼굴 색은 검정으로 설정함.
 * 
 * 눈의 경우 왼쪽 눈, 오른쪽 눈을 따로 지정하여 설정된 얼굴 베이스에 비율이 잘 맞도록 눈이 위치할 좌표를 설정함.
 * 눈은 원에서 현을 그어 거꾸로 뒤집힌 반달을 사용하기 위해 ArcType에서 CHORD로 설정하고 모두 흰색으로 칠함.
 * 왼쪽 눈은 220도에서부터 180도 움직인 길이로, 오른쪽 눈은 140도에서 180도 움직인 길이로 설정함.
 * 
 * 입의 경우 웃는 입모양의 반대가 되도록 하였는데, 이때 ArcType에서 OPEN을 사용하여 호만 나타나도록 함.
 * 입의 기본 선의 색은 흰색으로 설정하고 선의 굵기는 5d로 함.
 * 
 * 눈물 표현은 삼각형과 원을 눈물 모양으로 포개어 표현함.
 * 삼각형과 원 모두 청록색으로 설정하였고, 삼각형의 경우 세개의 좌표를 기준 좌표에 더하여 설정함.
 * 원의 경우 삼각형 밑 부분에 붙을 수 있도록 좌표 설정을 삼각형 밑변의 가운데로 맞추어 설정함.
 */

public class DrawSadFace extends Application {
	public static class SadFace extends Group{
		public SadFace(double x, double y) {
			constructFace(x, y);
		}
		private void constructFace(double xLeft, double yTop) {
			Circle face = new Circle(xLeft+100d,yTop+100d,100d);
			face.setFill(Color.BLACK);
			Arc leftEye = new Arc(xLeft+60d,yTop+75d,20d,20d,220d,180d);
			leftEye.setType(ArcType.CHORD);
			leftEye.setFill(Color.WHITE);
			Arc rightEye = new Arc(xLeft+140d,yTop+75d,20d,20d,140d,180d);
			rightEye.setType(ArcType.CHORD);
			rightEye.setFill(Color.WHITE);
			Arc mouth = new Arc(xLeft+100d,yTop+155d,40d,40d,15d,150d);
			mouth.setType(ArcType.OPEN);
			mouth.setStroke(Color.WHITE);
			mouth.setStrokeWidth(5d);
			Polygon tear1 = new Polygon();
			tear1.getPoints().addAll(new Double[]{
					xLeft+140d, yTop+100d,
					xLeft+130d, yTop+150d,
					xLeft+150d, yTop+150d});
			tear1.setFill(Color.CYAN);
			Circle tear2 = new Circle(xLeft+140d,yTop+150d,9.8d);
			tear2.setFill(Color.CYAN);
			getChildren().addAll(face,leftEye,rightEye,mouth,tear1,tear2);
		}
	}
	
	/*
	 * face1,2를 만들어 기본 위치를 설정함.
	 * Group 대신 기본 Pane을 사용함.
	 * 윈도우 초기 크기는 500d, 500d로 설정함.
	 * 창의 제목은 Sad Face로 설정하여 화면에 윈도우를 보여줌.
	 * main 메소드에서 launch 메소드 호출함.
	 */
	@Override
	public void start(Stage mainStage) throws Exception {
		SadFace face1 = new SadFace(50d, 250d);
		SadFace face2 = new SadFace(250d, 50d);
		Pane pane = new Pane();
		pane.getChildren().addAll(face1, face2);
		mainStage.setTitle("Sad Face");
		mainStage.setScene(new Scene(pane, 500d, 500d));
		mainStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
