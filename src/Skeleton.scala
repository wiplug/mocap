import scala.io.Source._
import scala.actors._

/**
 * Created by IntelliJ IDEA.
 * User: lieslw
 * Date: 4/22/12
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 *
 * Clearly some trouble committing from Windows. This file is for
 * storing the skeleton structure. I believe we only need one type. Form is:
 * pelv<aX> pelv<aY> pelv<aZ> pelv<tX> pelv<tY> pelv<tZ> lfem<aX> ...
 * The rest of the numbers in the line specify the remaining joints.
 * These joints are specified in the following order:
   pelvis 1->2 6 10
    lfemur 2->3
      ltibia 3->4
        lfoot 4->5
          ltoes 5->
    rfemur 6->7
      rtibia 7->8
        rfoot 8->9
          rtoes 9->
    thorax 10-> 11 15
      lclavicle 11->12
        lhumerus 12->13
          lradius 13->14
            lhand 14->
      rclavicle 15->16
        rhumerus 16->17
          rradius 17->18
            rhand 18->
 */

class Skeleton {
  //skeleton & motions(List)
  var name : String
  var defaultLength : Double
  var defaultMass : Double
  var angleUnit : String
  var skel : String
  var originalFileType : String
  var motions : List[String]
  var newrep: List[Double]
  var grdvel: List[Double]
  var velocity: Double

  //def load function: check file type: bvh, asf & acm, or txt?
  def loadSkeleton(filename: String) {

  }

  def loadMotion(filename: String) {

  }

  def downsampling(rate : Int) {
    motions.filter()
  }

  def preprocessing1(skel: Skeleton) {

  }

  def preprocessing2(skel: Skeleton) {

  }

  def loadAcclaimFile(filename : String){
    originalFileType = "acclaim"
    name = filename
    //open file
    val line = fromFile(filename).getLines()
    var where = ""
    var lin = Nil
    //read a line
    for(text<-line){
      lin = text.split("""[\s]+""")
      if(lin(0)==""){//if tab first check second
        lin(1) match{
          case "mass" =>
            if(where==""){
              defaultMass = lin(2).toDouble()
            }
          case "length" =>
            if(where==""){
              defaultLength = lin(2).toDouble()
            }
          case "angle" =>
            angleUnit = lin(2)
        }
      } else{
          lin(0) match{
            case ":root" =>
            case ":bonedata" => where =":bonedata"
          }
      }
    }
  }

}
