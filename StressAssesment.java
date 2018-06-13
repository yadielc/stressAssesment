package stressassesment;

/*
StressAssesment.java
Author: Yadiel F. Cabrera

Description:

This is the back-end to an expert system done in Java.
The purpose of this back-end is to process the data from a psicological questionnaire and simulate
the decision making process of a licensed therapist to determine if the patient needs therapy or not.


 */

import Rule.*;

/**
 *
 * @author Cabrera
 */
public class StressAssesment {

    // Knowledge Base (Knowledge Engine)
    BooleanRuleBase ruleBase = new BooleanRuleBase("Rule Base");

    // Rule Variables
    RuleVariable majorStress  = new RuleVariable (ruleBase, "");
    RuleVariable seriousStress  = new RuleVariable (ruleBase, "");
    RuleVariable moderateStress  = new RuleVariable (ruleBase, "");
    RuleVariable mildStress  = new RuleVariable (ruleBase, "");
    RuleVariable littleStress = new RuleVariable (ruleBase, "");
    RuleVariable conclusionVulnerability = new RuleVariable (ruleBase, "");
    RuleVariable recommendation = new RuleVariable (ruleBase, "");
    RuleVariable studyHabits = new RuleVariable (ruleBase, "");



    //Therapy Category
    RuleVariable deathOfFamily = new RuleVariable (ruleBase, ""); // 100
    RuleVariable deathOfFriend = new RuleVariable (ruleBase, ""); // 73
    RuleVariable divorceOfParent = new RuleVariable (ruleBase, ""); // 65
    RuleVariable jailTerm = new RuleVariable (ruleBase, "");
    RuleVariable majorIllness = new RuleVariable (ruleBase, "");
    RuleVariable marriage  = new RuleVariable (ruleBase, "");
    RuleVariable firedFromJob  = new RuleVariable (ruleBase, "");
    RuleVariable changeInHealthOfFamilyMember = new RuleVariable (ruleBase, "");
    RuleVariable pregnancy  = new RuleVariable (ruleBase, "");
    RuleVariable sexProblems  = new RuleVariable (ruleBase, "");
    RuleVariable seriousArgumentFriend  = new RuleVariable (ruleBase, "");
    RuleVariable changeFinancialStatus  = new RuleVariable (ruleBase, "");
    RuleVariable changeAcademicMajor  = new RuleVariable (ruleBase, "");
    RuleVariable troubleWithParents  = new RuleVariable (ruleBase, "");
    RuleVariable newRomanticPartner  = new RuleVariable (ruleBase, "");
    RuleVariable seriousArgumentInstructor  = new RuleVariable (ruleBase, "");
    RuleVariable changeSocialActivities  = new RuleVariable (ruleBase, "");
    RuleVariable changeFamilyGetTogethers = new RuleVariable (ruleBase, "");
    RuleVariable changeOfCollege  = new RuleVariable (ruleBase, "");
    RuleVariable outstandingPersonal  = new RuleVariable (ruleBase, "");
    RuleVariable changeInLivingConditions  = new RuleVariable (ruleBase, "");

    // Academic Category
    RuleVariable lowerGrades =  new RuleVariable (ruleBase, "");
    RuleVariable tooManyMissedClasses  = new RuleVariable (ruleBase, "");
    RuleVariable droppedMoreOneClass  = new RuleVariable (ruleBase, "");
    RuleVariable firstSemester  = new RuleVariable (ruleBase, "");
    RuleVariable increasedWorkload  = new RuleVariable (ruleBase, "");
    RuleVariable failedImportantCourse  = new RuleVariable (ruleBase, "");

    // Wellbeing Category
    RuleVariable changeSleepingHabits  = new RuleVariable (ruleBase, "");
    RuleVariable changeEatingHabits  = new RuleVariable (ruleBase, "");

    // Other Variables
    RuleVariable chronicCarTrouble  = new RuleVariable (ruleBase, "");
    RuleVariable minorTrafficViolations  = new RuleVariable (ruleBase, "");

      // Conclusions (new rules) obtained from forward chaining algorithm
      //    RuleVariable resultTherapy, resultAcademic, resultWellbeing, resultOther;

      // Dialog Message variables for each conclusion
     //    RuleVariable conclusionTherapy, conclusionAcademic, conclusionWellbeing;

    private  String resultT, resultA, resultWb;

    private String resultDeathOfFamilyMember = "";
    private String resultDeathOfCloseFriend = "";
    private String resultDivorceOfParents= "";
    private String resultJailTerm = "";
    private String resultPersonalInjuryIllness = "";
    private String resultMarriage = "";
    private String resultFiredFromJob = "";
    private String resultFailedImportantClass = "";
    private String resultChangeHealthFamilyMember = "";
    private String resultPregnancy = "";
    private String resultSexProblems = "";
    private String resultSeriousArgumentCloseFriend = "";
    private String resultChangeInFinances = "";
    private String resultChangeInMajor = "";
    private String resultTroubleWithParents = "";
    private String resultNewRomanticPartner = "";
    private String resultChangeSocialActivities = "";
    private String resultChangeFamilyGetTogethers = "";
    private String resultChangeOfCollege = "";
    private String resultOutstandingPersonal = "";
    private String resultChangeInLivingConditions = "";
    private String resultLowerGrades = "";
    private String resultTooManyMissedClasses = "";
    private String resultDroppedMoreOneClass = "";
    private String resultFirstSemester = "";
    private String resultIncreasedWorkload = "";
    private String resultChangeSleepingHabits = "";
    private String resultChangeEatingHabits = "";
    private String resultChronicCarTrouble = "";
    private String resultMinorTrafficViolations = "";
    private String resultSeriousArgumentWithInstructor = "";

    private  String resultMajorStress= "";
    private  String resultSeriousStress= "";
    private  String resultModerateStress= "";
    private  String resultMildStress= "";
    private  String resultLowStress= "";

   public static  String needsTherapy = "";
     String academic = "";
    public static  String interpretation ="";

     public static String reportVulnerability = " ";
     public static String reportRecommendation =" ";
     public static String reportInterpretation = "";


    private int score = 0;

    // Method that calculates the score of the questionnaire depending on
    public int calcScore() {
        int score = 0;
        int count = 0;

        if (resultDeathOfFamilyMember == "yes")
            score += 100;
        if (resultDeathOfCloseFriend == "yes")
            score += 73;
        if (resultDivorceOfParents == "yes")
            score += 65;
        if(resultJailTerm =="yes")
            score += 63;
        if(resultPersonalInjuryIllness =="yes")
            score += 63;
        if(resultMarriage == "yes")
            score += 58;
        if(resultFiredFromJob =="yes")
            score += 50;
        if(resultFailedImportantClass =="yes")
            score += 47;
        if(resultChangeHealthFamilyMember =="yes")
            score += 45;
        if(resultPregnancy == "yes")
            score += 45;
        if(resultSexProblems =="yes")
            score += 44;
        if(resultSeriousArgumentCloseFriend =="yes")
           score += 40;
        if (resultChangeInFinances == "yes")
            score += 39;
        if (resultChangeInMajor =="yes")
            score += 39;
        if(resultTroubleWithParents =="yes")
            score += 39;
        if(resultNewRomanticPartner =="yes")
            score += 38;
        if(resultIncreasedWorkload =="yes")
            score += 37;
        if (resultOutstandingPersonal =="yes")
            score += 36;
        if (resultFirstSemester == "yes")
            score += 35;
        if(resultChangeInLivingConditions =="yes")
            score += 31;
        if(resultSeriousArgumentWithInstructor =="yes")
            score += 30;
        if(resultLowerGrades =="yes")
            score += 29;
        if (resultChangeSleepingHabits =="yes")
            score += 29;
        if (resultChangeEatingHabits =="yes")
            score += 28;
        if (resultChangeSocialActivities =="yes")
            score += 29;
        if(resultChronicCarTrouble =="yes")
            score += 26;
        if(resultChangeFamilyGetTogethers =="yes")
            score += 26;
        if (resultTooManyMissedClasses=="yes")
            score += 25;
        if(resultChangeOfCollege =="yes")
            score += 24;
        if(resultDroppedMoreOneClass == "yes")
            score += 23;
        if (resultMinorTrafficViolations =="yes")
            score += 20;
         System.out.println("Score:" + score);
        return score;
    }


    // Gets the answer data from the user interface
    public void getData (String dF, String dFR, String dP, String jT, String mI, String me, String fJ,
                  String fIC, String cHF, String py, String sP, String sAF, String cF, String cAM, String tWP,
                  String nRP, String iW, String oPA, String fS, String cLC, String sAI, String lG, String cS, String cSA,
                  String cEH, String cCT, String cFG, String tMC, String cC, String dC, String mTV) {


        resultDeathOfFamilyMember = dF;
        resultDeathOfCloseFriend = dFR;
        resultDivorceOfParents = dP;
        resultJailTerm = jT;
        resultPersonalInjuryIllness = mI;
        resultMarriage = me;
        resultFiredFromJob = fJ;
        resultFailedImportantClass = fIC;
        resultChangeHealthFamilyMember = cHF;
        resultPregnancy = py;
        resultSexProblems = sP;
        resultSeriousArgumentCloseFriend = sAF;
        resultChangeInFinances = cF;
        resultChangeInMajor = cAM;
        resultTroubleWithParents = tWP;
        resultNewRomanticPartner = nRP;
        resultIncreasedWorkload = iW;
        resultOutstandingPersonal = oPA;
        resultFirstSemester = fS;
        resultChangeInLivingConditions = cLC;
        resultSeriousArgumentWithInstructor = sAI;
        resultLowerGrades = lG;
        resultChangeSleepingHabits = cS;
        resultChangeSocialActivities =cSA;
        resultChangeEatingHabits = cEH;
        resultChronicCarTrouble = cCT;
        resultChangeFamilyGetTogethers = cFG;
        resultTooManyMissedClasses = tMC;
        resultChangeOfCollege = cC;
        resultDroppedMoreOneClass = dC;
        resultMinorTrafficViolations = mTV;


        score = calcScore ();

        correlateData (score);

        knowledgeBase(); // ESTO FUE LO QUE ARREGLO EL PROBLEMA del Set Text

        deathOfFamily.setValue(resultDeathOfFamilyMember);
        deathOfFriend.setValue(resultDeathOfCloseFriend);
        divorceOfParent.setValue(resultDivorceOfParents);
        jailTerm.setValue(resultJailTerm);
        majorIllness.setValue(resultPersonalInjuryIllness);
        marriage.setValue(resultMarriage);
        firedFromJob.setValue(resultFiredFromJob);
        changeInHealthOfFamilyMember.setValue(resultChangeHealthFamilyMember);
        pregnancy.setValue(resultPregnancy);
        seriousArgumentInstructor.setValue(resultSeriousArgumentWithInstructor);
        changeFinancialStatus.setValue(resultChangeInFinances);
        changeAcademicMajor.setValue(resultChangeInMajor);
        troubleWithParents.setValue(resultTroubleWithParents);
        newRomanticPartner.setValue(resultNewRomanticPartner);
        changeSocialActivities.setValue(resultChangeSocialActivities);
        changeFamilyGetTogethers.setValue(resultChangeFamilyGetTogethers);
        changeOfCollege.setValue(resultChangeOfCollege);
        outstandingPersonal.setValue(resultOutstandingPersonal);
        changeInLivingConditions.setValue(resultChangeInLivingConditions);
        lowerGrades.setValue(resultLowerGrades);
        tooManyMissedClasses.setValue(resultTooManyMissedClasses);
        droppedMoreOneClass.setValue(resultDroppedMoreOneClass);
        firstSemester.setValue(resultFirstSemester);
        increasedWorkload.setValue(resultIncreasedWorkload);
        failedImportantCourse.setValue(resultFailedImportantClass);
        changeSleepingHabits.setValue(resultChangeSleepingHabits);
        changeEatingHabits.setValue(resultChangeEatingHabits);
        chronicCarTrouble.setValue(resultChronicCarTrouble);
        minorTrafficViolations.setValue(resultMinorTrafficViolations);



        majorStress.setValue(resultMajorStress);
        seriousStress.setValue(resultSeriousStress);
        mildStress.setValue(resultMildStress);
        littleStress.setValue(resultLowStress);

        userInterface.flag = 1;



        // Save decision results
        reportInterpretation = interpretation;


       ruleBase.forwardChain();

       reportVulnerability = conclusionVulnerability.getValue();
       reportRecommendation = recommendation.getValue();

        System.out.println("Inside Stress Assesment: " +  conclusionVulnerability.getValue());
        System.out.println("Inside Stress Assesment: " + recommendation.getValue());

        System.out.println("Inside Stress Assesment Report Intpretation:" + interpretation);
        System.out.println("Inside Stress Assesment Needs Therapy:" + needsTherapy);
    }


// Correlation algorithm
public void correlateData (int score) {
        // THERAPY CATEGORY CASES
            if(score > 300){
              if (resultDeathOfFamilyMember == "yes" || resultDeathOfCloseFriend =="yes" || resultDivorceOfParents=="yes"|| resultJailTerm=="yes"|| resultPersonalInjuryIllness =="yes" || resultFiredFromJob == "yes" || resultChangeHealthFamilyMember =="yes" || resultPregnancy =="yes" || resultSexProblems == "yes" || resultChangeInFinances =="yes"|| resultSeriousArgumentWithInstructor =="yes" || resultChangeSocialActivities =="yes" || resultChangeFamilyGetTogethers =="yes" || resultChangeOfCollege =="yes" || resultOutstandingPersonal =="yes" || resultChangeInLivingConditions =="yes"){
                    academic ="no";
                    needsTherapy="yes";
                    interpretation ="Major Stress.";
                    resultMajorStress = "yes";

               }
                    academic ="no";
                    needsTherapy ="yes";
                    interpretation ="Major Stress.";
                    resultMajorStress = "yes";



              }
              else if(score < 300 && score >251){
                  if (resultDeathOfFamilyMember == "yes" || resultDeathOfCloseFriend =="yes" || resultDivorceOfParents=="yes"|| resultJailTerm=="yes"|| resultPersonalInjuryIllness =="yes" || resultFiredFromJob == "yes" || resultChangeHealthFamilyMember =="yes" || resultPregnancy =="yes" || resultSexProblems == "yes" || resultChangeInFinances =="yes"|| resultSeriousArgumentWithInstructor =="yes" || resultChangeSocialActivities =="yes" || resultChangeFamilyGetTogethers =="yes" || resultChangeOfCollege =="yes" || resultOutstandingPersonal =="yes" || resultChangeInLivingConditions =="yes"){
                    academic = "no";
                    needsTherapy="yes";
                    interpretation ="Serious Stress.";
                    resultSeriousStress = "yes";
                  }
                   academic = "no";
                   needsTherapy="yes";
                   interpretation ="Serious Stress.";
                   resultSeriousStress = "yes";

              }
              else if(score < 250 && score > 200){
                    if (resultDeathOfFamilyMember == "yes" || resultDeathOfCloseFriend =="yes" || resultDivorceOfParents=="yes"|| resultJailTerm=="yes"|| resultPersonalInjuryIllness =="yes" || resultFiredFromJob == "yes" || resultChangeHealthFamilyMember =="yes" || resultPregnancy =="yes" || resultSexProblems == "yes" || resultChangeInFinances =="yes"|| resultSeriousArgumentWithInstructor =="yes" || resultChangeSocialActivities =="yes" || resultChangeFamilyGetTogethers =="yes" || resultChangeOfCollege =="yes" || resultOutstandingPersonal =="yes" || resultChangeInLivingConditions =="yes"){
                      academic = "no";
                      needsTherapy ="yes";
                      interpretation ="Moderate Stress.";
                      resultModerateStress ="yes";
                    }
              }
              else if(score < 199 && score > 150){
                   if (resultDeathOfFamilyMember == "yes" || resultDeathOfCloseFriend =="yes" || resultDivorceOfParents=="yes"|| resultJailTerm=="yes"|| resultPersonalInjuryIllness =="yes" || resultFiredFromJob == "yes" || resultChangeHealthFamilyMember =="yes" || resultPregnancy =="yes" || resultSexProblems == "yes" || resultChangeInFinances =="yes"|| resultSeriousArgumentWithInstructor =="yes" || resultChangeSocialActivities =="yes" || resultChangeFamilyGetTogethers =="yes" || resultChangeOfCollege =="yes" || resultOutstandingPersonal =="yes" || resultChangeInLivingConditions =="yes"){
                      academic ="no";
                      needsTherapy ="yes";
                      interpretation ="Mild Stress.";
                      resultMildStress ="yes";
                   }

                     academic ="no";
                     needsTherapy ="no";
                     interpretation ="Mild Stress.";
                     resultMildStress ="yes";
              }

              else if (score < 149){
                  if (resultDeathOfFamilyMember == "yes" || resultDeathOfCloseFriend =="yes" || resultDivorceOfParents=="yes"|| resultJailTerm=="yes"|| resultPersonalInjuryIllness =="yes" || resultFiredFromJob == "yes" || resultChangeHealthFamilyMember =="yes" || resultPregnancy =="yes" || resultSexProblems == "yes" || resultChangeInFinances =="yes"|| resultSeriousArgumentWithInstructor =="yes" || resultChangeSocialActivities =="yes" || resultChangeFamilyGetTogethers =="yes" || resultChangeOfCollege =="yes" || resultOutstandingPersonal =="yes" || resultChangeInLivingConditions =="yes"){
                    academic ="no";
                    needsTherapy = "yes";
                    interpretation ="Very little stress.";
                    resultLowStress ="yes";
                  }
              }



        // ACADEMIC CASES

        if (score > 300) {
            if(resultLowerGrades == "yes" || resultTooManyMissedClasses =="yes" || resultTooManyMissedClasses =="yes" || resultDroppedMoreOneClass =="yes" || resultFirstSemester =="yes" || resultIncreasedWorkload =="yes" || resultFailedImportantClass =="yes" ) {
                academic ="yes";
                needsTherapy ="yes";
                interpretation ="Major Stress";

              }
            }
            else if(score < 300 && score >251){
                if(resultLowerGrades == "yes" || resultTooManyMissedClasses =="yes" || resultTooManyMissedClasses =="yes" || resultDroppedMoreOneClass =="yes" || resultFirstSemester =="yes" || resultIncreasedWorkload =="yes" || resultFailedImportantClass =="yes" ) {
                    academic ="yes";
                    needsTherapy ="yes";
                    interpretation ="Serious Stress";
                }
                else if(score < 250 && score > 200){
                       if(resultLowerGrades == "yes" || resultTooManyMissedClasses =="yes" || resultTooManyMissedClasses =="yes" || resultDroppedMoreOneClass =="yes" || resultFirstSemester =="yes" || resultIncreasedWorkload =="yes" || resultFailedImportantClass =="yes" ) {
                         academic = "yes";
                         needsTherapy = "yes";
                         interpretation ="Moderate Stress.";
                       }
                }
                else if(score < 199 && score > 150) {
                       if(resultLowerGrades == "yes" || resultTooManyMissedClasses =="yes" || resultTooManyMissedClasses =="yes" || resultDroppedMoreOneClass =="yes" || resultFirstSemester =="yes" || resultIncreasedWorkload =="yes" || resultFailedImportantClass =="yes" ) {
                           academic ="yes";
                           needsTherapy ="no";
                           interpretation ="Mild stress.";
                       }
                }
                else if (score < 149){
                      if(resultLowerGrades == "yes" || resultTooManyMissedClasses =="yes" || resultTooManyMissedClasses =="yes" || resultDroppedMoreOneClass =="yes" || resultFirstSemester =="yes" || resultIncreasedWorkload =="yes" || resultFailedImportantClass =="yes" ) {
                         academic ="yes";
                         needsTherapy ="no";
                         interpretation ="Very little stress.";
                        }
                    }
        }
}


// REPORT DATA
public void reportData (int score) {


}


    /**
     * @param args the command line arguments
     */

    // Knowledge base of the expert system
    public void knowledgeBase() {
               // Declare rulevariable to use forward-chaining algorithm to determine the decision
               recommendation = new RuleVariable(ruleBase, "");   // 100

                // Condition which will evaluate rules in order for the Expert System to make decisions
                // = Yes or = No
                Condition equals = new Condition("=");

                //Very High Vulnerability cases
                Rule veryHighVulnerability1 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(deathOfFamily, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability2 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(deathOfFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability3 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(divorceOfParent, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability4 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(jailTerm, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability5 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(majorIllness, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule  veryHighVulnerability6 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(firedFromJob, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability7 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( changeInHealthOfFamilyMember, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability8 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( changeInHealthOfFamilyMember, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability9 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( pregnancy, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability10 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( sexProblems, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability11 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( seriousArgumentFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability12 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(changeFinancialStatus, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability13 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(changeAcademicMajor, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability14 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(troubleWithParents, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability15 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause(newRomanticPartner, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability16 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (majorStress, equals, "yes"),
                new Clause( seriousArgumentFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability17 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (mildStress, equals, "yes"),
                new Clause( deathOfFamily, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule veryHighVulnerability18 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (mildStress, equals, "yes"),
                new Clause( deathOfFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                 Rule veryHighVulnerability19 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (moderateStress, equals, "yes"),
                new Clause( deathOfFamily, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                 Rule veryHighVulnerability20 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (moderateStress, equals, "yes"),
                new Clause( deathOfFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                 Rule veryHighVulnerability21 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (littleStress, equals, "yes"),
                new Clause( deathOfFriend, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                 Rule veryHighVulnerability22 = new Rule (ruleBase, "VeryHighVulnerability", new Clause [] {
                new Clause (littleStress, equals, "yes"),
                new Clause( deathOfFamily, equals, "yes")},
                    new Clause (conclusionVulnerability, equals, "Very High Vulnerability"));

                Rule decision1 = new Rule (ruleBase, "HighVulnerability", new Clause [] {
                new Clause (conclusionVulnerability, equals, "Very High Vulnerability")},
                    new Clause (recommendation, equals, "Your levels of stress out of control and you are very vulnerable to serious health issues associated with stress. You should visit a mental health professional as soon as possible."));

                Rule decision2 = new Rule (ruleBase, "HighVulnerability", new Clause [] {
                new Clause (conclusionVulnerability, equals, "High Vulnerability")},
                    new Clause (recommendation, equals, "You should visit a mental health professional. 787-455-8737"));

                Rule decision3 = new Rule (ruleBase, "HighVulnerability", new Clause [] {
                new Clause (conclusionVulnerability, equals, "High Vulnerability")},
                    new Clause (recommendation, equals, "You should visit a mental health professional. 787-455-8737"));

                Rule decision4 = new Rule (ruleBase, "RegularVulnerability", new Clause [] {
                new Clause (conclusionVulnerability, equals, "Vulnerable.")},
                    new Clause (recommendation, equals, "Your stress levels are normal."));

                Rule decision5 = new Rule (ruleBase, "LowVulnerability", new Clause [] {
                new Clause (conclusionVulnerability, equals, "Low Vulnerability")},
                    new Clause (recommendation, equals, "Your stress levels are low and are barely vulnerable to any serious health risks associated with stress."));

                //Academic recommendations
                Rule decision6 = new Rule (ruleBase, "Organize Schedule", new Clause [] {
                new Clause (tooManyMissedClasses, equals, "yes")},
                    new Clause (recommendation, equals, "You need to organize your schedule and cannot miss any more classes."));


                Rule decision7 = new Rule (ruleBase, "Verify Study Habits", new Clause [] {
                new Clause (lowerGrades, equals, "yes")},
                    new Clause (recommendation, equals, "You need to verify your study habits."));
           };

}
