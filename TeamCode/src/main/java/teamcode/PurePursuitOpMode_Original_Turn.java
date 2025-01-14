package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.DuckDetector;

import java.util.ArrayList;

import treamcode.CurvePoint;

//import Functions.CurvePoint;

@Autonomous(name="PurePursuitOpMode_Original_Turn", group="Linear Opmode")

public class PurePursuitOpMode_Original_Turn extends LinearOpMode {

    private PurePursuitRobotMovement6_Turn myPurePursuitRobotMovement6_Turn;
//    private wobble_Pickup mywobble_Pickup;
//    private DetectObjects_Shoot_Class myDetectObjects;

    boolean debugFlag = true;

    int purePursuitPath = 1;
    DuckDetector.DuckDeterminationPipeline.DuckPosition duckPosition;
    DuckDetector duckDetector;


    @Override
    public void runOpMode() {

//        mywobble_Pickup = new wobble_Pickup (this);
//        myDetectObjects = new DetectObjects_Shoot_Class(this);
//        mywobble_Pickup.wobbleInit();
//        myDetectObjects.initialize();
        //Initialize the PID Calculators

//        purePursuitPath = myDetectObjects.runDetectShoot();

        telemetry.addData("Vision", "Completed");
        telemetry.update();

        //Create a NerdBOT object
        myPurePursuitRobotMovement6_Turn = new PurePursuitRobotMovement6_Turn(this);
        myPurePursuitRobotMovement6_Turn.setDebug(debugFlag);

        //Initialize Hardware
        myPurePursuitRobotMovement6_Turn.initializeHardware();


        duckDetector = new DuckDetector(this);
        duckDetector.initDuckDetector();
        telemetry.addData("Analysis",duckDetector.getAnalysis());
        telemetry.update();

        waitForStart();

        telemetry.addData("Analysis",duckDetector.getAnalysis());
        telemetry.update();

        duckPosition = duckDetector.getAnalysis();


//        if (duckDetector.getAnalysis().equals(DuckDetector.DuckDeterminationPipeline.DuckPosition.CENTER)) {
//        if (duckPosition == DuckDetector.DuckDeterminationPipeline.DuckPosition.CENTER){
        if (purePursuitPath == 1){
            //First Path to the Square 4

//            ArrayList<CurvePoint> allPoints = new ArrayList<>();
//            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 40, 0, 0.3));
//            allPoints.add(new CurvePoint(0, 50, 0.4, 0.3, 40, 180, 0.3));
//            allPoints.add(new CurvePoint(0, 100, 0.4, 0.3, 40, 180, 0.3));
//
//            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 0, 15, 180, 3);

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-27, 22, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 0, 15, -90, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-27, 22, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(-34, 10, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(-45, -30, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 0, 10, -120, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-34, 10, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(-25, 22, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(0, 48, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 0, 10, -90, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-25, 22, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(21, 8, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(60, 8, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 0, 10, -160, 1);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(21, 8, 0.8, 0.3, 40, 0, 0.3));
            allPoints.add(new CurvePoint(-24, 4, 0.8, 0.3, 40, 180, 0.3));
            allPoints.add(new CurvePoint(-83, 0, 0.8, 0.3, 40, 180, 0.3));
            allPoints.add(new CurvePoint(-130, 0, 0.8, 0.3, 40, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, -0.25, 35, -180, 5);

            //----------------------------------------------


        }else if (duckPosition == DuckDetector.DuckDeterminationPipeline.DuckPosition.LEFT){

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 90, 15, 120, 3);

        }else{

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-26, 26, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6_Turn.followCurve(allPoints, 90, 15, 120, 3);

        }
    }

}

