def command="echo Hi"
def proc = command.execute()
proc.waitFor()
def choices = proc.in.text.tokenize()
return choices.sort()

def ad_search_frp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh ].execute()
def abc1 = abc.text.tokenize()

def bid_search_frp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh ].execute()
def xyz1 = xyz.text.tokenize()

def ad_search_fxp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh ].execute()
def ijk1 = ijk.text.tokenize()

def bid_search_fxp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh ].execute()
def lmn1 = lmn.text.tokenize()

if (NODE_GROUP.equals("abc1")) {
   return abc1
}
else if (NODE_GROUP.equals("xyz1")) {
   return xyz1
}
else if (NODE_GROUP.equals("ijk1")) {
   return ijk1
}
else if (NODE_GROUP.equals("lmn1")) {
   return lmn1
}
else{
   return ["Unknown Server Type"]
}

env=ENV.take(1)
if (NODE_GROUP.contains("abc")) {
   def proc = ["sh", "-c", "echo version1_${ENV} version2_${ENV} version3_${ENV} version4_${ENV} version5_${ENV} version6_${ENV}"].execute()
   proc.waitFor()
   def clashboardVariables=proc.in.text.tokenize()
   if (clashboardVariables) {
      return clashboardVariables.sort()
}
}
else if (NODE_GROUP.contains("xyz")) {
   def proc = ["sh", "-c", "echo version_${ENV}"].execute()
   proc.waitFor()
   def clashboardVariables=proc.in.text.tokenize()
   if (clashboardVariables) {
      return clashboardVariables.sort()
}
}
else{
   return ["Unknown Server Type"]
}
