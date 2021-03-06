package rajawali.lights;

import rajawali.math.Vector3;

public class DirectionalLight extends ALight {
	protected float[] mDirection = new float[3];

	public DirectionalLight() {
		this(0, -1.0f, 1.0f);
	}

	public DirectionalLight(float xDir, float yDir, float zDir) {
		super(DIRECTIONAL_LIGHT);
		setDirection(xDir, yDir, zDir);
	}

	public void setDirection(float x, float y, float z) {
		mDirection[0] = x;
		mDirection[1] = y;
		mDirection[2] = z;
	}

	public void setDirection(Vector3 dir) {
		setDirection(dir.x, dir.y, dir.z);
	}

	public float[] getDirection() {
		return mDirection;
	}

	public void setLookAt(float x, float y, float z) {
		super.setLookAt(x, y, z);
		Vector3 dir = new Vector3(x, y, z);
		dir.subtract(mPosition);
		dir.x = -dir.x;
		dir.normalize();
		setDirection(dir);
	}
}
