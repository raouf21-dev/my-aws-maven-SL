import com.example

def call(String imageName){
    return new Docker(this).dockerPush(imageName)
}