package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.DuckDetector;

import treamcode.CurvePoint;
import treamcode.NerdPID_PurePursuit;
import treamcode.wobble_Pickup;

import java.util.ArrayList;

//import Functions.CurvePoint;

@Autonomous(name="PurePursuitOpMode_Original", group="Linear Opmode")

public class PurePursuitOpMode_Original extends LinearOpMode {

    private PurePursuitRobotMovement6 myPurePursuitRobotMovement6;
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
        myPurePursuitRobotMovement6 = new PurePursuitRobotMovement6(this);
        myPurePursuitRobotMovement6.setDebug(debugFlag);

        //Initialize Hardware
        myPurePursuitRobotMovement6.initializeHardware();


        duckDetector = new DuckDetector(this);
        duckDetector.initDuckDetector();
        telemetry.addData("Analysis",duckDetector.getAnalysis());
        telemetry.update();

        waitForStart();

        telemetry.addData("Analysis",duckDetector.getAnalysis());
        telemetry.update();

        duckPosition = duckDetector.getAnalysis();


//        if (duckDetector.getAnalysis().equals(DuckDetector.DuckDeterminationPipeline.DuckPosition.CENTER)) {
        if (duckPosition == DuckDetector.DuckDeterminationPipeline.DuckPosition.CENTER){
            //First Path to the Square 4

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 15, -30, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(-30, 10, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(-45, -30, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 10, -120, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-30, 10, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(0, 48, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 10, -30, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.4, 25, 0, 0.3));
            allPoints.add(new CurvePoint(18, 10, 0.4, 0.4, 25, 180, 0.3));
            allPoints.add(new CurvePoint(60, 10, 0.4, 0.4, 25, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 10, 182, 3);

            sleep(2000);

            allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(18, 10, 0.8, 0.3, 40, 0, 0.3));
            allPoints.add(new CurvePoint(-24, 8, 0.8, 0.3, 40, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 1, 0.8, 0.3, 40, 180, 0.3));
            allPoints.add(new CurvePoint(-130, 1, 0.8, 0.3, 40, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 35, 180, 5);



        }else if (duckPosition == DuckDetector.DuckDeterminationPipeline.DuckPosition.LEFT){

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-22, 22, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 15, 120, 3);

        }else{

            ArrayList<CurvePoint> allPoints = new ArrayList<>();
            allPoints.add(new CurvePoint(0, 0, 0.4, 0.3, 20, 0, 0.3));
            allPoints.add(new CurvePoint(-26, 26, 0.4, 0.3, 20, 180, 0.3));
            allPoints.add(new CurvePoint(-80, 80, 0.4, 0.3, 20, 180, 0.3));

            myPurePursuitRobotMovement6.followCurve(allPoints, 90, 15, 120, 3);

        }
    }

}

